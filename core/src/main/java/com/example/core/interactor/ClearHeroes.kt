package com.example.core.interactor

import com.example.core.data.heroes.HeroesRepository

class ClearHeroes(
    private val heroesRepository: HeroesRepository
) {
    suspend operator fun invoke() = heroesRepository.clearHeroes()
}