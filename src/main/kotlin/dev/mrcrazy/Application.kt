package dev.mrcrazy

import dev.mrcrazy.plugins.configureKoin
import dev.mrcrazy.plugins.configureRouting
import dev.mrcrazy.routes.customerRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.locations.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module(testing: Boolean = false) {
    install(IgnoreTrailingSlash)
    install(Locations)
    install(ContentNegotiation) {
        json()
    }

    routing {
        configureKoin()
        configureRouting()
        customerRoutes()
    }
}