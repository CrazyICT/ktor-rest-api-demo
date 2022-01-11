package dev.mrcrazy.features.customers.data.dao

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Customers : IntIdTable("customers") {
    val firstName = varchar("first_name", 100)
    val lastName = varchar("last_name", 100)
    val middleName = varchar("middle_name", 100).nullable()
    val phoneNumber = varchar("phone", 15).nullable()
    val mobileNumber = varchar("mobile", 15).nullable()
    val email = varchar("email", 150).nullable()
    val companyName = varchar("company_name", 100).nullable()
}

class Customer(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Customer>(Customers)

    var firstName by Customers.firstName
    var lastName by Customers.lastName
    var companyName by Customers.companyName
    var middleName by Customers.middleName
    var phoneNumber by Customers.phoneNumber
    var mobileNumber by Customers.mobileNumber
    var email by Customers.email
    val addresses by Address optionalReferrersOn Addresses.customer
}