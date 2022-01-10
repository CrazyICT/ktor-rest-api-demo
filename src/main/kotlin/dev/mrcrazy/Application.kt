package dev.mrcrazy

import dev.mrcrazy.config.setupConfig
import dev.mrcrazy.data.DatabaseFactory
import dev.mrcrazy.di.appModule
import dev.mrcrazy.plugins.configureRouting
import dev.mrcrazy.routes.customerRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.netty.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.core.module.Module

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false, koinModules: List<Module> = listOf(appModule)) {
    install(Koin) {
        modules(koinModules)
    }
    install(IgnoreTrailingSlash)
    install(Locations)
    install(ContentNegotiation) {
        json()
    }

    setupConfig()

    val databaseFactory by inject<DatabaseFactory>()
    databaseFactory.connect()
    databaseFactory.createTables()

    routing {
        customerRoutes()
        configureRouting()
    }
}