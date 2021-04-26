package com.example.guidemknew.data

import android.content.Context
import com.example.core.data.HeroesDataSource
import com.example.core.data.OperationDataSource
import com.example.core.domain.Heroes
import com.example.guidemknew.Database
import com.example.guidemknew.DatabaseAppQueries
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

class SqlHeroesDataSource(context: Context) : HeroesDataSource, OperationDataSource {

    val dbQueries: DatabaseAppQueries

    init {
        val driver: SqlDriver = AndroidSqliteDriver(Database.Schema, context, "HeroesDb.db")
        dbQueries = Database(driver).databaseAppQueries
    }


    override suspend fun getAllHeroes() = dbQueries.selectAll().executeAsList()
        .map {
            Heroes(it.id, it.name, it.urlImage)
        }.toMutableList()


    override suspend fun clear() = dbQueries.clearDb()

}