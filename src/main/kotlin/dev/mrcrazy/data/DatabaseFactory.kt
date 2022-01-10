package dev.mrcrazy.data

interface DatabaseFactory {
    fun connect()
    fun createTables()
}