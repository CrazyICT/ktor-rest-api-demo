package dev.mrcrazy.data.services

import dev.mrcrazy.models.Customer
import dev.mrcrazy.repositories.CustomerRepository

class CustomersServiceImpl(private val customerRepository: CustomerRepository) : CustomerServices {
    override fun fetchAllCustomers(): List<Customer> {
        return customerRepository.fetchCustomers()
    }

    override fun fetchById(id: Int): Customer? {
        return customerRepository.fetchById(id)
    }
}