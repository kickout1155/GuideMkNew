package com.example.core.data

class MainRepository(
    private val mainDataSource: MainDataSource
) {
    suspend fun getVersion() = mainDataSource.getVersion()
}