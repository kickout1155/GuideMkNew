package com.example.core.interactor

import com.example.core.data.heroes.HeroesRepository

class GetHeroes(private val heroesRepository: HeroesRepository) {
    suspend operator fun invoke() = heroesRepository.getAllHeroes()
}