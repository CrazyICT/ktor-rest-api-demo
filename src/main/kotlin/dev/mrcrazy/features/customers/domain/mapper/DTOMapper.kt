package dev.mrcrazy.features.customers.domain.mapper

import dev.mrcrazy.features.customers.data.dao.Address
import dev.mrcrazy.features.customers.data.dao.Customer
import dev.mrcrazy.features.customers.domain.model.AddressDTO
import dev.mrcrazy.features.customers.domain.model.CustomerDTO

fun Customer.toDTO(): CustomerDTO {
    return CustomerDTO(
        id = this.id.value,
        firstName = this.firstName,
        lastName = this.lastName,
        middleName = this.middleName,
        phoneNumber = this.phoneNumber,
        mobileNumber = this.mobileNumber,
        email = this.email,
        companyName = this.companyName,
        addresses = this.addresses.toList().map { address -> address.toDTO() }
    )
}

fun Address.toDTO(): AddressDTO {
    return AddressDTO(
        street = this.street,
        houseNumber = this.houseNumber,
        houseNumberExtension = this.houseNumberExtension,
        zipcode = this.zipcode,
        city = this.city
    )
}