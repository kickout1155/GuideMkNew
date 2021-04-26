package com.example.core.data

import com.example.core.domain.Heroes

interface HeroesDataSource {
    suspend fun getAllHeroes():MutableList<Heroes>
}