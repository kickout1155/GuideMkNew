package com.example.core.interactor

import com.example.core.data.HeroesRepository
import com.example.core.data.OperationDataSource

class Clear(private val operationDataSource: OperationDataSource) {
    suspend operator fun invoke() = operationDataSource.clear()
}