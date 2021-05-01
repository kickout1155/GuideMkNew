package com.example.guidemknew.ui

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core.domain.Hero
import com.example.guidemknew.R
import com.example.guidemknew.ui.base.BaseViewHolder
import com.example.guidemknew.databinding.RvMainFragmentHeroesItemBinding

class ViewHolderHeroesMain(itemView: View) : BaseViewHolder<Hero>(itemView) {

    private var _binding: RvMainFragmentHeroesItemBinding? = null
    val binding get() = _binding!!
    var context:Context
    val option : RequestOptions = RequestOptions()

    init {
        _binding = RvMainFragmentHeroesItemBinding.bind(itemView)
        context =  binding.root.context
        option.apply {
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_background)
        }
    }

    override fun bind(item: Hero) {
        binding.tvNameHero.text = item.name
        Glide
            .with(context)
            .load(item.urlImage)
            .apply(option)
            .into(binding.ivImageHero)
    }
}