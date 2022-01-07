package dev.mrcrazy.routes

import dev.mrcrazy.data.services.CustomerServices
import dev.mrcrazy.models.Customer
import dev.mrcrazy.models.customerStorage
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
    post("/") {
        val customer = call.receive<Customer>()
        customerStorage.add(customer)

        call.respondText("Customer created", status = HttpStatusCode.Created)
    }
}

fun Route.list() {
    val service: CustomerServices by inject()

    get("/") {

        call.respond(service.fetchAllCustomers())
//        if (customerStorage.isNotEmpty()) {
//            call.respond(customerStorage)
//        } else {
//            call.respondText("No results", status = HttpStatusCode.NoContent)
//        }
    }
}

fun Route.find() {
    val service: CustomerServices by inject()

    get("{id}") {
        val id = call.parameters["id"]?.toInt() ?: -1
        val customerResult = service.fetchById(id)

        if (customerResult === null) {
            call.respondText(
                "No customer with id $id",
                status = HttpStatusCode.NotFound
            )
        } else {
            call.respond(customerResult)
        }
//        val customerResult = customerStorage.find {
//            it.id == id!!.toInt()
//        } ?: return@get call.respondText(
//            "No customer with id $id",
//            status = HttpStatusCode.NotFound
//        )

    }
}