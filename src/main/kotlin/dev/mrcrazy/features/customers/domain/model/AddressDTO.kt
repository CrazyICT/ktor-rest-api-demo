package dev.mrcrazy.features.customers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AddressDTO(
    val id: Int? = null,
    val street: String,
    val houseNumber: String,
    val houseNumberExtension: String? = null,
    val zipcode: String,
    val city: String,
)
