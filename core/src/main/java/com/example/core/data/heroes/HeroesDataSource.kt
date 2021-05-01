package com.example.core.data.heroes

import com.example.core.domain.Hero

interface HeroesDataSource {
    suspend fun getAllHeroes(): MutableList<Hero>
    suspend fun updateHeroes(heroes: MutableList<Hero>)
    suspend fun updateHeroById(id: String, hero: Hero)
    suspend fun clearHero()
}