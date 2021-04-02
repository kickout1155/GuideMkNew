package com.example.guidemknew

import com.example.guidemknew.base.BaseMapper
import com.example.guidemknew.modelNetwork.Heroes
import javax.inject.Inject

class MapperHeroes @Inject constructor() : BaseMapper<Heroes, HeroesDb>() {

    override fun map(value: Heroes) = HeroesDb(
        value.id,
        value.name,
        value.urlImage
    )

    override fun listMap(list: MutableList<Heroes>): MutableList<HeroesDb> {
        return list.map {
            HeroesDb(it.id, it.name, it.urlImage)
        }.toMutableList()
    }
}