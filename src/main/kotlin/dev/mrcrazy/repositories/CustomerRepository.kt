package dev.mrcrazy.repositories

import dev.mrcrazy.data.db.CustomerEntity
import dev.mrcrazy.data.db.DatabaseConnection
import dev.mrcrazy.models.Customer
import org.ktorm.dsl.*

class CustomerRepository {
    val db = DatabaseConnection.database

    fun fetchCustomers(): List<Customer> {
        println("Fetching the notes")
        return db.from(CustomerEntity).select().map {
            val id = it[CustomerEntity.id]
            val firstName = it[CustomerEntity.firstname]
            Customer(id ?: -1, firstName ?: "")
        }
    }

    fun fetchById(id: Int): Customer? {
        return db.from(CustomerEntity).select()
            .where { CustomerEntity.id eq id }
            .map {
                val firstName = it[CustomerEntity.firstname]!!
                Customer(id = id, firstName = firstName)
            }.firstOrNull()
    }
}