package com.svyd.beerbrowser.presentation.feature.beers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.svyd.beerbrowser.R
import com.svyd.beerbrowser.data.repository.beers.model.Beer

//todo: implement item addition via notifyItemChanged and using DiffUtil, implement pagination
class BeersAdapter : RecyclerView.Adapter<BeersAdapter.BeerHolder>() {

    private val beers: MutableList<Beer> = ArrayList()

    fun updateBeers(newBeers: List<Beer>)  {
        beers.clear()
        beers.addAll(newBeers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerHolder
    = BeerHolder(LayoutInflater.from(parent.context)
        .inflate(R.layout.list_item_beer, parent, false))

    override fun getItemCount(): Int {
        return beers.size
    }

    override fun onBindViewHolder(holder: BeerHolder, position: Int) {
        holder.setBeer(beers[position])
    }

    inner class BeerHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.image)
        private val name: TextView = view.findViewById(R.id.name)
        private val description: TextView = view.findViewById(R.id.description)

        fun setBeer(beer: Beer) {
            Glide.with(view)
                .load(beer.image)
                .into(image)
        }
    }
}