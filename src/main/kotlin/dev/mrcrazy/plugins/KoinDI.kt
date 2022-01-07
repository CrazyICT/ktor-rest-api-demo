package dev.mrcrazy.plugins

import dev.mrcrazy.di.customerModule
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun Application.configureKoin() {
    install(Koin) {
        modules(customerModule)
    }
}