package com.miramicodigo.restful1.adapter

import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.miramicodigo.restful1.R
import com.miramicodigo.restful1.model.Pokemon

class PokemonAdapter(private val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    private val dataset: ArrayList<Pokemon> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_poke, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = dataset[position]



    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun adicionarListaPokemon(listaPokemon: ArrayList<Pokemon>) {
        dataset.addAll(listaPokemon)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoImageView: ImageView = itemView.findViewById(R.id.ivImagen) as ImageView
        val nombreTextView: TextView = itemView.findViewById(R.id.tvNombre)
    }
}