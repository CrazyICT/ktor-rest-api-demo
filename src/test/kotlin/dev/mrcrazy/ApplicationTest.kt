package dev.mrcrazy

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
//    @Test
//    fun testRoot() {
//        withTestApplication({ module(testing = true) }) {
//            handleRequest(HttpMethod.Get, "/").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals("The Fun API", response.content)
//            }
//        }
//    }

//    @Test
//    fun testCustomerListing() {
//        withTestApplication({ module(testing = true) }) {
//            handleRequest(HttpMethod.Get, "/api/v1/customers").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals("""[{"id":10,"firstName":"Tim"}]""", response.content)
//            }
//        }
//    }

//    @Test
//    fun testCanCreateCustomer() = withTestApplication({ module(testing = true)}) {
//            with(handleRequest(HttpMethod.Post, "/api/v1/customers") {
//                addHeader(HttpHeaders.Accept, ContentType.Application.Json.toString())
//                addHeader(HttpHeaders.ContentType, ContentType.Application.Json.toString())
//                setBody("""{"id": 10, "firstName": "Tim" }""")
//            }) {
//                assertEquals(HttpStatusCode.Created, response.status())
//                assertEquals("Customer created", response.content)
//            }
//    }
}