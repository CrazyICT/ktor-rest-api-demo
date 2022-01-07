package dev.mrcrazy.models

import kotlinx.serialization.Serializable

val customerStorage = mutableListOf<Customer>()

@Serializable
data class Customer(
    val id: Int,
    val firstName: String
)

@Serializable
data class CustomerRequest(val id: Int)