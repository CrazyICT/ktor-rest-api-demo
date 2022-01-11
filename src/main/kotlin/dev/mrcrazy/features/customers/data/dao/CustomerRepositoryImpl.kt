package dev.mrcrazy.features.customers.data.dao

import dev.mrcrazy.features.customers.domain.mapper.toDTO
import dev.mrcrazy.features.customers.domain.model.CustomerDTO
import dev.mrcrazy.features.customers.repositories.CustomerRepository
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class CustomerRepositoryImpl : CustomerRepository {

    override suspend fun fetchCustomers(): List<CustomerDTO> {
        val allCustomers = newSuspendedTransaction {
            val query = Customers.leftJoin(Addresses).selectAll()
            val data = Customer.wrapRows(query).toList()

            return@newSuspendedTransaction data.map { customer: Customer ->
                customer.toDTO()
            }
        }

        return allCustomers
    }

    override suspend fun fetchById(id: Int): CustomerDTO? {
        val customer = newSuspendedTransaction {
            val customer = Customer.findById(id)

            return@newSuspendedTransaction customer?.toDTO()
        }

        return customer
    }

    override suspend fun create(customer: CustomerDTO): Int {
        val customerResult = transaction {
            val result = Customers.insert {
                it[firstName] = customer.firstName
                it[middleName] = customer.middleName
                it[lastName] = customer.lastName
                it[phoneNumber] = customer.phoneNumber
                it[mobileNumber] = customer.mobileNumber
                it[companyName] = customer.companyName
                it[email] = customer.email
            } get Customers.id

            return@transaction result.value
        }

        return customerResult
    }

    override suspend fun update(customer: CustomerDTO): Int {
        val customer = transaction {
            Customers.update({ Customers.id eq customer.id }) {
                it[firstName] = customer.firstName
                it[middleName] = customer.middleName
                it[lastName] = customer.lastName
                it[phoneNumber] = customer.phoneNumber
                it[mobileNumber] = customer.mobileNumber
                it[companyName] = customer.companyName
                it[email] = customer.email

                customer.addresses?.forEach { addressDTO ->
                    Addresses.update({ Addresses.customer eq customer.id and(Addresses.id eq addressDTO.id) }) {
                        it[street] = addressDTO.street
                        it[zipcode] = addressDTO.zipcode
                        it[city] = addressDTO.city
                    }
                }
            }

        }

        return customer
    }
}