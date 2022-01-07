package dev.mrcrazy.di

import dev.mrcrazy.data.services.CustomerServices
import dev.mrcrazy.data.services.CustomersServiceImpl
import dev.mrcrazy.repositories.CustomerRepository
import org.koin.dsl.module

val customerModule = module {
    single<CustomerServices> { CustomersServiceImpl(get())}
    single { CustomerRepository() }
}