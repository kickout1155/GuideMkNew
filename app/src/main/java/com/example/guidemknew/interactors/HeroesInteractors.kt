package com.example.guidemknew.interactors

import com.example.core.interactor.*

data class HeroesInteractors(
    val getHeroes: GetHeroes,
    val clearHeroes: ClearHeroes,
    val updateHeroes: UpdateHeroes,
    val updateHeroesById: UpdateHeroesById
)