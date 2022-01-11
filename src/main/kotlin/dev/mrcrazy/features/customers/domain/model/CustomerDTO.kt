package dev.mrcrazy.features.customers.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CustomerDTO(
    val id: Int? = null,
    val firstName: String,
    val middleName: String? = null,
    val lastName: String,
    val phoneNumber: String? = null,
    val mobileNumber: String? = null,
    val email: String? = null,
    val companyName: String? = null,
    val addresses: List<AddressDTO>? = null
)