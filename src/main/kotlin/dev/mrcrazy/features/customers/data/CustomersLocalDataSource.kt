package dev.mrcrazy.features.customers.data

import dev.mrcrazy.features.customers.data.dao.Customer
import dev.mrcrazy.features.customers.domain.model.CustomerDTO

interface CustomersLocalDataSource {
    fun fetchById(id: Int): Customer?
    fun getAllCustomers(): List<Customer>
    fun addCustomer(customer: CustomerDTO): Int
}