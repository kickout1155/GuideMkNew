package com.example.guidemknew.di

import android.content.Context
import com.example.guidemknew.Database
import com.example.guidemknew.DatabaseAppQueries
import com.example.guidemknew.database.ActionDatabaseHeroes
import com.example.guidemknew.database.HeroesActionDatabaseHeroesImpl
import com.example.guidemknew.network.HeroesApi
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class DbModule {
//
//    @Provides
//    @Singleton
//    fun provideHeroesDb(
//        @ApplicationContext context: Context
//    ): ActionDatabaseHeroes = HeroesActionDatabaseHeroesImpl(context)
//
//}


@Module
@InstallIn(SingletonComponent::class)
class ModuleHeroesDb {

    @Provides
    @Singleton
    fun heroesDbProvide(@ApplicationContext context: Context): DatabaseAppQueries {
        val driver: SqlDriver =
            AndroidSqliteDriver(Database.Schema, context, "HeroesDb.db")
        return Database(driver).databaseAppQueries
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ClientModule {

    @Provides
    @Singleton
    fun clientProvide(): HttpClient {
        return HttpClient(Android) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
        }
    }

}