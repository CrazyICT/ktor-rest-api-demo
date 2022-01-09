package dev.mrcrazy.features.customers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CustomerDTO(
    val id: Int? = null,
    val firstName: String
)