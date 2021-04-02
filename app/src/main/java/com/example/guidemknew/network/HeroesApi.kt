package com.example.guidemknew.network

import com.example.guidemknew.modelNetwork.Heroes

interface HeroesApi {
    suspend fun getHeroes(): MutableList<Heroes>
}