package com.example.core.interactor

import com.example.core.data.HeroesRepository

class GetHeroes(private val heroesRepository: HeroesRepository) {
    suspend operator fun invoke() = heroesRepository.getAllHeroes()
}