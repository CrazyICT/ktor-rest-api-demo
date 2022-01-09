package dev.mrcrazy.features.customers.domain.mapper

import dev.mrcrazy.features.customers.data.dao.Customer
import dev.mrcrazy.features.customers.domain.model.CustomerDTO

fun Customer.toDTO(): CustomerDTO {
    return CustomerDTO(
        id = this.id.value,
        firstName = this.firstName
    )
}