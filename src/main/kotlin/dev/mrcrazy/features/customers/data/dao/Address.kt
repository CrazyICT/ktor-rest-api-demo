package dev.mrcrazy.features.customers.data.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Addresses : IntIdTable("addresses") {
    val street = varchar("street", 150)
    val houseNumber = varchar("house_number", 20)
    val houseNumberExtension = varchar("house_number_extension", 10).nullable()
    val zipcode = varchar("zipcode", 12)
    val city = varchar("city", 100)
    val customer = reference("customer_id", Customers).nullable()
}

class Address(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Address>(Addresses)

    var street by Addresses.street
    var houseNumber by Addresses.houseNumber
    var houseNumberExtension by Addresses.houseNumberExtension
    var zipcode by Addresses.zipcode
    var city by Addresses.city
    var customer by Customer optionalReferencedOn Addresses.customer
}