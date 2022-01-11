package dev.mrcrazy.data

import dev.mrcrazy.config.AppConfig
import dev.mrcrazy.features.customers.data.dao.Addresses
import dev.mrcrazy.features.customers.data.dao.Customers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseFactoryImpl(appConfig: AppConfig) : DatabaseFactory {
    private val dbConfig = appConfig.databaseConfig

    override fun connect() {
        Database.connect(
            url = dbConfig.url,
            driver = dbConfig.driverClass,
            user = dbConfig.user,
            password = dbConfig.password
        )
    }

    override fun createTables() = transaction {
        SchemaUtils.createMissingTablesAndColumns(
            Customers,
            Addresses
        )
    }
}