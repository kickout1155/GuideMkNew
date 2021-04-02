package com.example.guidemknew.network

import com.example.guidemknew.modelNetwork.Heroes
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import javax.inject.Inject


class HeroesApiImplements @Inject constructor(
    private val client: HttpClient
) : HeroesApi {
    private val baseUrl = "https://www.foodstart.ru"

    override suspend fun getHeroes(): MutableList<Heroes> {
        return client.get { url("$baseUrl/guide/hs/getAllHeroes") }
    }
}