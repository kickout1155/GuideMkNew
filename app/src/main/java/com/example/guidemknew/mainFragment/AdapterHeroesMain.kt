package com.example.guidemknew.mainFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.guidemknew.HeroesDb
import com.example.guidemknew.R
import com.example.guidemknew.base.BaseAdapter

class AdapterHeroesMain(
    private val click: (Int) -> Unit
) :
BaseAdapter<HeroesDb, ViewHolderHeroesMain>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHeroesMain {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_main_fragment_heroes_item, parent, false)
        val vh = ViewHolderHeroesMain(view)
        view.setOnClickListener {
            click(vh.adapterPosition)
        }
        return vh
    }
}