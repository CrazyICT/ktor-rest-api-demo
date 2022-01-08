package dev.mrcrazy.data.db

import org.ktorm.database.Database

object DatabaseConnection {
    val database = Database.connect(
        url = "jdbc:mysql://asdn-api-db:3306/asdn_api_test",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}