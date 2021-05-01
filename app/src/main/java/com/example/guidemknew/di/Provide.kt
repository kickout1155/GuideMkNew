package com.example.guidemknew.di

import android.content.Context
import com.example.core.data.heroes.HeroesRepository
import com.example.core.data.MainDataSource
import com.example.core.data.heroes.HeroesDataSource
import com.example.core.interactor.ClearHeroes
import com.example.core.interactor.GetHeroes
import com.example.core.interactor.UpdateHeroes
import com.example.core.interactor.UpdateHeroesById
import com.example.guidemknew.data.KtorHeroesDataSource
import com.example.guidemknew.data.PreferenceDataSource
import com.example.guidemknew.data.SqlHeroesDataSource
import com.example.guidemknew.interactors.HeroesInteractors
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

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
//
//@Module
//@InstallIn(SingletonComponent::class)
//class ModuleHeroesDb {
//
//    @Provides
//    @Singleton
//    fun heroesDbProvide(@ApplicationContext context: Context): DatabaseAppQueries {
//        val driver: SqlDriver =
//            AndroidSqliteDriver(Database.Schema, context, "HeroesDb.db")
//        return Database(driver).databaseAppQueries
//    }
//}
//
//@Module
//@InstallIn(SingletonComponent::class)
//class ClientModule {
//
//    @Provides
//    @Singleton
//    fun clientProvide(): HttpClient {
//        return HttpClient(Android) {
//            install(JsonFeature) {
//                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
//                    ignoreUnknownKeys = true
//                    isLenient = true
//                })
//            }
//        }
//    }
//
//}


@Module
@InstallIn(ViewModelComponent::class)
class InteractorsModule {

    @Provides
    fun interactorsProvide(@ApplicationContext context: Context): HeroesInteractors {
        return HeroesInteractors(
            GetHeroes(HeroesRepository(SqlHeroesDataSource(context))),
            ClearHeroes(HeroesRepository(SqlHeroesDataSource(context))),
            UpdateHeroes(HeroesRepository(SqlHeroesDataSource(context))),
            UpdateHeroesById(HeroesRepository(SqlHeroesDataSource(context)))
        )
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalVersion

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkVersion

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class SqlHeroesData

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class NetworkHeroesData

@Module
@InstallIn(SingletonComponent::class)
object VersionModule {

    @LocalVersion
    @Provides
    fun localProvide(): MainDataSource {
        return PreferenceDataSource()
    }

    @NetworkVersion
    @Provides
    fun networkProvide(): MainDataSource {
        return KtorHeroesDataSource()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
class UpdateModule {

    @SqlHeroesData
    @Provides
    fun sqlUpdateProvide(
        @ApplicationContext context: Context
    ): HeroesDataSource = SqlHeroesDataSource(context)

    @NetworkHeroesData
    @Provides
    fun networkUpdateProvide():HeroesDataSource = KtorHeroesDataSource()

}




