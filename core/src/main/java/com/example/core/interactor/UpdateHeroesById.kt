package com.example.core.interactor

import com.example.core.data.heroes.HeroesRepository
import com.example.core.domain.Hero

class UpdateHeroesById(
    private val heroesRepository: HeroesRepository
) {
    suspend operator fun invoke(id: String, hero: Hero) =
        heroesRepository.updateHeroById(id, hero)
}