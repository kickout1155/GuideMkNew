package com.example.guidemknew.data

import com.example.core.data.heroes.HeroesDataSource
import com.example.core.data.MainDataSource
import com.example.core.domain.Hero
import com.example.guidemknew.domain.HeroesNetwork
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*

class KtorHeroesDataSource : HeroesDataSource, MainDataSource {

    private val baseUrl = "https://www.foodstart.ru"
    private val httpClient = HttpClient(Android){
        install(JsonFeature)
    }

    override suspend fun getAllHeroes(): MutableList<Hero> =
        httpClient.get<MutableList<HeroesNetwork>> {
            url("$baseUrl/guide/hs/getAllHeroes")
        }.map {
            Hero(it.id, it.name, it.urlImage)
        }.toMutableList()

    override suspend fun updateHeroes(heroes: MutableList<Hero>) {

    }

    override suspend fun updateHeroById(id: String, hero: Hero) {

    }

    override suspend fun clearHero() {

    }

    override suspend fun getVersion(): Double {
        return 1.1
    }

    override suspend fun saveVersion() {

    }
}


//    override suspend fun getHeroes(): MutableList<com.example.guidemknew.modelNetwork.Heroes> {
//        return client.get { url("$baseUrl/guide/hs/getAllHeroes") }
//    }
//
//    override suspend fun getVersionOnServer(): Int {
//        return client.get { url("$baseUrl/guide/hs/getMain/main/getVersion") }
//    }

