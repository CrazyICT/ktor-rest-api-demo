package dev.mrcrazy.features.customers

import dev.mrcrazy.features.customers.domain.model.CustomerDTO
import dev.mrcrazy.features.customers.repositories.CustomerRepository

class CustomersService(private val customerRepository: CustomerRepository) {
     suspend  fun fetchAllCustomers(): List<CustomerDTO> {
        return customerRepository.fetchCustomers()
    }

    suspend fun fetchById(id: Int): CustomerDTO? {
        return customerRepository.fetchById(id)
    }

    suspend fun create(customer: CustomerDTO): Int {
        return customerRepository.create(customer)
    }
}