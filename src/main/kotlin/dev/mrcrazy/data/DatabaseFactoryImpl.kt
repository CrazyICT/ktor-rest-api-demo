package dev.mrcrazy.data

import dev.mrcrazy.config.AppConfig
import org.jetbrains.exposed.sql.Database

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
}