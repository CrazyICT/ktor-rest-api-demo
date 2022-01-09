package dev.mrcrazy.features.customers.repositories

import dev.mrcrazy.features.customers.domain.model.CustomerDTO

interface CustomerRepository {

    suspend fun fetchCustomers(): List<CustomerDTO>

    suspend fun fetchById(id: Int): CustomerDTO?

    suspend fun create(customer: CustomerDTO): Int
}