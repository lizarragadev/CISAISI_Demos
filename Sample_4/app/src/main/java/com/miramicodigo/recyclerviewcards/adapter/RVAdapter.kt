package com.miramicodigo.recyclerviewcards.adapter

import android.content.Intent
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import com.miramicodigo.recyclerviewcards.ui.DetalleActivity
import com.miramicodigo.recyclerviewcards.R
import com.miramicodigo.recyclerviewcards.model.Pokemon

internal class RVAdapter(activity: Activity, private val items: ArrayList<Pokemon>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    private val context: Context

    init {
        this.context = activity
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Para LinearLayoutManager
        //val v = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        //Para GridLayout y StaggeredGridLayout
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_item_grid, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tf_black = Typeface.createFromAsset(context.assets, "fonts/roboto_black.ttf")
        val tf_thin = Typeface.createFromAsset(context.assets, "fonts/roboto_thin.ttf")

        holder.tvTitulo.typeface = tf_black
        holder.tvSubtitulo.typeface = tf_thin

        val poke = items[position]




    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView
        val tvSubtitulo: TextView
        val ivImagen: ImageView

        init {
            tvTitulo = itemView.findViewById(R.id.tvTitulo) as TextView
            tvSubtitulo = itemView.findViewById(R.id.tvSubtitulo) as TextView
            ivImagen = itemView.findViewById(R.id.ivImagen) as ImageView

            itemView.setOnClickListener {



            }
        }
    }
}
