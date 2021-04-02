package com.example.guidemknew.database

import android.content.Context
import com.example.guidemknew.Database
import com.example.guidemknew.DatabaseAppQueries
import com.example.guidemknew.HeroesDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.hilt.android.qualifiers.ApplicationContext
import java.security.PrivateKey
import javax.inject.Inject


class HeroesActionDatabaseHeroesImpl @Inject constructor(
    private val database: DatabaseAppQueries
) : ActionDatabaseHeroes {

    override suspend fun clearDb() {
        database.clearDb()
    }

    override suspend fun getAllHeroes(): MutableList<HeroesDb> {
        return database.selectAll().executeAsList() as MutableList<HeroesDb>
    }

    override suspend fun insertHeroes(heroesDb: HeroesDb) {
        database.insertObject(heroesDb)
    }

    override suspend fun updateHeroesDb(heroesDb: HeroesDb) {
        database.updateHeroesDb(
            heroesDb.id,
            heroesDb.name,
            heroesDb.urlImage,
            heroesDb.id
        )
    }
}