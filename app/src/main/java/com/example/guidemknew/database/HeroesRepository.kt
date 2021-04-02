package com.example.guidemknew.database

import android.content.Context
import com.example.guidemknew.HeroesDb
import com.example.guidemknew.modelNetwork.Heroes
import com.example.guidemknew.network.HeroesApi
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

//@ViewModelScoped
class HeroesRepository @Inject constructor(
    private val actionDatabaseHeroes: ActionDatabaseHeroes,
    private val heroesApi: HeroesApi
) {

    suspend fun getHeroesNetwork():MutableList<Heroes>{
        return heroesApi.getHeroes()
    }

    suspend fun clearDb() {
        actionDatabaseHeroes.clearDb()
    }

    suspend fun getAll(): MutableList<HeroesDb> {
        return actionDatabaseHeroes.getAllHeroes()
    }

    suspend fun insertHeroes(heroesDb: HeroesDb) {
        actionDatabaseHeroes.insertHeroes(heroesDb)
    }

    suspend fun updateHeroesDb(heroesDb: HeroesDb) {
        actionDatabaseHeroes.updateHeroesDb(heroesDb)
    }


}