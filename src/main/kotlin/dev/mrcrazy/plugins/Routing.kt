package dev.mrcrazy.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {

    // val environment = environment.config.propertyOrNull("ktor.environment")?.getString() ?: "development"

    routing {
        get("/") {
            // call.application.environment.log.info("Hello!")
            call.respondText("The Fun API")
        }
    }
}
