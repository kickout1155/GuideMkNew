package com.example.guidemknew.data

import android.content.Context
import com.example.core.data.heroes.HeroesDataSource
import com.example.core.domain.Hero
import com.example.guidemknew.Database
import com.example.guidemknew.DatabaseAppQueries
import com.example.guidemknew.HeroesDb
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

class SqlHeroesDataSource(context: Context) : HeroesDataSource {

    val dbQueries: DatabaseAppQueries

    init {
        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, context, "HeroesDb.db")
        dbQueries = Database(driver).databaseAppQueries
    }


    override suspend fun getAllHeroes() = dbQueries.selectAll().executeAsList()
        .map {
            Hero(it.id, it.name, it.urlImage)
        }.toMutableList()

    override suspend fun updateHeroes(heroes: MutableList<Hero>) {
        heroes.forEach {
            dbQueries.insertObject(HeroesDb(it.id,it.name,it.urlImage))
        }
    }

    override suspend fun updateHeroById(id: String, hero: Hero) {

    }

    override suspend fun clearHero() {
        dbQueries.clearDb()
    }


}