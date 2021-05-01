package com.example.guidemknew.helpers

import com.example.core.data.heroes.HeroesDataSource
import com.example.guidemknew.di.NetworkHeroesData
import com.example.guidemknew.di.NetworkVersion
import com.example.guidemknew.di.SqlHeroesData
import javax.inject.Inject

class UpdateHeroesImpl @Inject constructor (
    @SqlHeroesData private val sqlDataSource: HeroesDataSource,
    @NetworkHeroesData private val networkDataSource: HeroesDataSource
):UpdateHeroesHelper {

    override suspend fun update() {
        val networkResult = networkDataSource.getAllHeroes()
        sqlDataSource.clearHero()
        sqlDataSource.updateHeroes(networkResult)
    }
}