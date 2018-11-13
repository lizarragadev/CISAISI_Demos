package com.miramicodigo.recyclerviewcards.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.RecyclerView
import android.app.Activity
import com.miramicodigo.recyclerviewcards.R
import com.miramicodigo.recyclerviewcards.adapter.RVAdapter
import com.miramicodigo.recyclerviewcards.model.Pokemon
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var datos: ArrayList<Pokemon>
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adaptador: RecyclerView.Adapter<*>
    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        //layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        //layoutManager = GridLayoutManager(applicationContext, 2)
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)




    }

    fun llenarPokemones() {
        datos = ArrayList()
        val resources = resources
        val arrayTitulos = resources.getStringArray(R.array.titulos)
        val arraySubtitulos = resources.getStringArray(R.array.subtitulos)
        val arrayImagenes = resources.obtainTypedArray(R.array.imagenes)
        for (i in arrayTitulos.indices) {



        }
    }

}
