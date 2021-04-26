package com.example.guidemknew.data

import com.example.core.data.HeroesDataSource
import com.example.core.data.MainDataSource
import com.example.core.domain.Heroes
import com.example.guidemknew.domain.HeroesNetwork
import io.ktor.client.*
import io.ktor.client.request.*

class KtorHeroesDataSource : HeroesDataSource,MainDataSource {

    private val baseUrl = "https://www.foodstart.ru"
    private val httpClient = HttpClient()

    override suspend fun getAllHeroes(): MutableList<Heroes> =
        httpClient.get<MutableList<HeroesNetwork>> {
            url("$baseUrl/guide/hs/getAllHeroes")
        }.map {
            Heroes(it.id, it.name, it.urlImage)
        }.toMutableList()

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

