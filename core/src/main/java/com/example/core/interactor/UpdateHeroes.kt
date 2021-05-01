package com.example.core.interactor

import com.example.core.data.heroes.HeroesRepository
import com.example.core.domain.Hero

class UpdateHeroes(
    private val heroesRepository: HeroesRepository
) {
    suspend operator fun invoke(heroes: MutableList<Hero>) =
        heroesRepository.updateHeroes(heroes)
}