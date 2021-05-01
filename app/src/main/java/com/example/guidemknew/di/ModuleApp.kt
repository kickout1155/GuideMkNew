package com.example.guidemknew.di

import com.example.guidemknew.helpers.UpdateHeroesHelper
import com.example.guidemknew.helpers.UpdateHeroesImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class UpdateHeroesHelperModule {

    @Binds
    abstract fun bindUpdateHeroesHelperModule(
        updateHeroes: UpdateHeroesImpl
    ): UpdateHeroesHelper
}
//
//@Module
//@InstallIn(ViewModelComponent::class)
//abstract class HeroesApiModule {
//
//    @Binds
//    abstract fun bindHeroesApi(
//        heroesApiImplements: HeroesApiImplements
//    ): HeroesApi
//}





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