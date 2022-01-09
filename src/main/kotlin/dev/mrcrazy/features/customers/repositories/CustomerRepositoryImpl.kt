package dev.mrcrazy.features.customers.repositories

import dev.mrcrazy.features.customers.data.CustomersLocalDataSource
import dev.mrcrazy.features.customers.data.dao.Customer
import dev.mrcrazy.features.customers.domain.mapper.toDTO
import dev.mrcrazy.features.customers.domain.model.CustomerDTO
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class CustomerRepositoryImpl(
    private val customersLocalDataSource: CustomersLocalDataSource
) : CustomerRepository {

    override suspend fun fetchCustomers(): List<CustomerDTO> {
        val allCustomers = newSuspendedTransaction {
            val all = customersLocalDataSource.getAllCustomers()

            return@newSuspendedTransaction all.map { customer: Customer ->
                customer.toDTO()
            }
        }

        return allCustomers
    }

    override suspend fun fetchById(id: Int): CustomerDTO? {
        val customer = newSuspendedTransaction {
            val customer = customersLocalDataSource.fetchById(id)

            return@newSuspendedTransaction customer?.toDTO()
        }

        return customer
    }

    override suspend fun create(customer: CustomerDTO): Int {
        val customerResult = newSuspendedTransaction {
            val newId = customersLocalDataSource.addCustomer(customer)

            return@newSuspendedTransaction newId
        }

        return customerResult
    }
}