package kuchmenko.com

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kuchmenko.com.plugins.*
import kuchmenko.com.routes.registerCustomerRoutes
import kuchmenko.com.routes.registerOrderRoute

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        module()
    }.start(wait = true)
}

fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    registerCustomerRoutes()
    registerOrderRoute()
}
