package dev.mrcrazy.data.db

import org.ktorm.database.Database

object DatabaseConnection {
    val database = Database.connect(
        url = "jdbc:mysql://localhost:3306/asdn_ktor",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}