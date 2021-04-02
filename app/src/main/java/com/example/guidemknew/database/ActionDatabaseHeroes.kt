package com.example.guidemknew.database

import com.example.guidemknew.HeroesDb

interface ActionDatabaseHeroes {

    suspend fun clearDb()

    suspend fun getAllHeroes(): MutableList<HeroesDb>

    suspend fun insertHeroes(heroesDb: HeroesDb)

    suspend fun updateHeroesDb(heroesDb: HeroesDb)
}