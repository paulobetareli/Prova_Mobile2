package com.example.paulo.prova_mobile.scenarios_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.paulo.prova_mobile.R
import com.example.paulo.prova_mobile.entities.Drink
import com.example.paulo.prova_mobile.utils.GlideApp
import kotlinx.android.synthetic.main.news_item.view.*

class DrinkAdapter(val context: Context, val drinks: List<Drink>)
    : RecyclerView.Adapter<DrinkAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return drinks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, drinks[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, drink: Drink, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.tvTitle.text = drink.strDrink

            GlideApp.with(context)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(itemView.imgNews)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }

        }

    }

}