package dev.mrcrazy.features.customers.data

import dev.mrcrazy.features.customers.data.dao.Customer
import dev.mrcrazy.features.customers.data.dao.Customers
import dev.mrcrazy.features.customers.domain.model.CustomerDTO
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class CustomersLocalDataSourceImpl: CustomersLocalDataSource {
    override fun getAllCustomers(): List<Customer> {
        val query = Customers.selectAll()

        return Customer.wrapRows(query).toList()
    }

    override fun fetchById(id: Int): Customer? {

        return Customer.findById(id)
    }

    override fun addCustomer(customer: CustomerDTO): Int {
        val insertedId = transaction {
            Customers.insert {
                it[firstName] = customer.firstName
            } get Customers.id
        }

        return insertedId.value
    }
}