package dev.mrcrazy.di

import dev.mrcrazy.config.AppConfig
import dev.mrcrazy.data.DatabaseFactory
import dev.mrcrazy.data.DatabaseFactoryImpl
import dev.mrcrazy.features.customers.CustomersService
import dev.mrcrazy.features.customers.data.dao.CustomerRepositoryImpl
import dev.mrcrazy.features.customers.repositories.CustomerRepository
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {
    single<AppConfig>()
    single<DatabaseFactory> { DatabaseFactoryImpl(get()) }

    // Customers
    single<CustomerRepository> { CustomerRepositoryImpl() }
    single<CustomersService>()
}