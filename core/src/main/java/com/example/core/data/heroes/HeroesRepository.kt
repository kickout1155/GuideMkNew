package com.example.core.data.heroes

import com.example.core.domain.Hero


class HeroesRepository(
    private val dataSource: HeroesDataSource,
) {
    suspend fun getAllHeroes() = dataSource.getAllHeroes()
    suspend fun updateHeroes(heroes: MutableList<Hero>)=dataSource.updateHeroes(heroes)
    suspend fun updateHeroById(id: String, hero: Hero) = dataSource.updateHeroById(id,hero)
    suspend fun clearHeroes() = dataSource.clearHero()
}