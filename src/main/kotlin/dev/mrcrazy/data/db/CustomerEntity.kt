package dev.mrcrazy.data.db

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object CustomerEntity : Table<Nothing>("customers"){
    val id  = int("id").primaryKey()
    val firstname = varchar("firstname")
}