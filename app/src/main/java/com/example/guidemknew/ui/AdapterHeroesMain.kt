package com.example.guidemknew.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.core.domain.Hero
import com.example.guidemknew.R
import com.example.guidemknew.ui.base.BaseAdapter

class AdapterHeroesMain(
    private val click: (Int) -> Unit
) :
BaseAdapter<Hero, ViewHolderHeroesMain>() {


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