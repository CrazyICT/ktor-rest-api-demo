package dev.mrcrazy.routes

import dev.mrcrazy.features.customers.CustomersService
import dev.mrcrazy.features.customers.domain.model.CustomerDTO
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.customerRoutes() {
    routing {
        route("/api/v1/customers") {
            create()
            list()
            find()
        }
    }
}

fun Route.create() {
    val service by inject<CustomersService>()

    post("/") {
        val customerDTO = call.receive<CustomerDTO>()
        val newId = service.create(customerDTO)

        call.respond(customerDTO.copy(id = newId))
    }
}

fun Route.list() {
    val service by inject<CustomersService>()

    get("/") {
        val customers = service.fetchAllCustomers()

        if (customers.isNotEmpty()) {
            call.respond(customers)
        } else {
            call.respondText("No results", status = HttpStatusCode.NoContent)
        }
    }
}

fun Route.find() {
    val service: CustomersService by inject()

    get("{id}") {
        val id = call.parameters["id"]?.toInt() ?: -1
        val customerResult = service.fetchById(id)

        if (customerResult === null) {
            call.respondText(
                "No customer with id test $id",
                status = HttpStatusCode.NotFound
            )
        } else {
            call.respond(customerResult)
        }
    }
}