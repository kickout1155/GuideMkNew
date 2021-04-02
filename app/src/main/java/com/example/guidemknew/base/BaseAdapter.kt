package com.example.guidemknew.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    protected val listItems = mutableListOf<T>()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    fun getItem(position: Int): T {
        return listItems[position]
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    fun addItems(list: MutableList<T>) {
        listItems.addAll(list)
    }

    fun clear(){
        listItems.clear()
    }
}