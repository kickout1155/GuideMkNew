package com.example.core.interactor

import com.example.core.data.MainRepository

class GetVerson(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke() = mainRepository.getVersion()
}