package com.example.core.data

class HeroesRepository(
    private val dataSource: HeroesDataSource,
    private val operationDataSource: OperationDataSource
    ) {
    suspend fun getAllHeroes()=dataSource.getAllHeroes()
    suspend fun clear() = operationDataSource.clear()
}