package dev.mrcrazy.data.services

import dev.mrcrazy.models.Customer

interface CustomerServices {
    fun fetchAllCustomers(): List<Customer>

    fun fetchById(id: Int): Customer?
}