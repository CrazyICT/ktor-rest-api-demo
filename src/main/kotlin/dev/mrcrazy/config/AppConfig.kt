package dev.mrcrazy.config

import io.ktor.application.*
import org.koin.ktor.ext.inject

class AppConfig {
    lateinit var databaseConfig: DatabaseConfig
}

fun Application.setupConfig() {
    val appConfig by inject<AppConfig>()

    // database
    val databaseUrl = environment.config.propertyOrNull("ktor.database.url")?.getString() ?: "development"
    val databaseDriver = environment.config.propertyOrNull("ktor.database.driver")?.getString() ?: ""
    val databaseUser = environment.config.propertyOrNull("ktor.database.user")?.getString() ?: ""
    val databasePassword = environment.config.propertyOrNull("ktor.database.password")?.getString() ?: ""

    appConfig.databaseConfig = DatabaseConfig(databaseDriver, databaseUrl, databaseUser, databasePassword)
}

data class DatabaseConfig(
    val driverClass: String,
    val url: String,
    val user: String,
    val password: String
)