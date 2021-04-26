package com.example.core.data

interface MainDataSource {

    suspend fun getVersion():Double
    suspend fun saveVersion()
}