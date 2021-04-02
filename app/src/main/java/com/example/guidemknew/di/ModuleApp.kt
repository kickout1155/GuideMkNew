package com.example.guidemknew.di

import com.example.guidemknew.database.ActionDatabaseHeroes
import com.example.guidemknew.database.HeroesActionDatabaseHeroesImpl
import com.example.guidemknew.network.HeroesApi
import com.example.guidemknew.network.HeroesApiImplements
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ActionDatabaseHeroesModule {

    @Binds
    abstract fun bindActionDatabaseHeroes(
        heroesDbRepository: HeroesActionDatabaseHeroesImpl
    ): ActionDatabaseHeroes
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class HeroesApiModule {

    @Binds
    abstract fun bindHeroesApi(
        heroesApiImplements: HeroesApiImplements
    ): HeroesApi
}





//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class MappingHeroesModule{
//
//    @Binds
//    abstract fun bindMappingHeroes(
//        mappingHeroesImpl: MappingHeroesImpl
//    ): BaseMapping<Heroes,HeroesDb>
//
//}