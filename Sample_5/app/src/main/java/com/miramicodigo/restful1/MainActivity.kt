package com.miramicodigo.restful1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.miramicodigo.restful1.adapter.PokemonAdapter
import com.miramicodigo.restful1.model.PokemonResponse
import com.miramicodigo.restful1.service.PokeInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var listaPokemonAdapter: PokemonAdapter
    var cantidadLote: Int = 0
    var sePuedeCargar: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaPokemonAdapter = PokemonAdapter(this)
        recyclerView.adapter = listaPokemonAdapter
        recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = layoutManager





        sePuedeCargar = true
        cantidadLote = 0
        obtenerDatos(cantidadLote)

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if (dy > 0) {
                    val visibleCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val pastVisibleItems = layoutManager.findFirstVisibleItemPosition()

                    if (sePuedeCargar) {
                        if (visibleCount + pastVisibleItems >= totalItemCount) {
                            sePuedeCargar = false
                            cantidadLote += 20
                            obtenerDatos(cantidadLote)
                        }
                    }
                }
            }
        })
    }

    private fun obtenerDatos(offset: Int) {
        val service = retrofit.create(PokeInterface::class.java)
        val pokemonResponseCall =
                service.obtenerListaPokemon(offset, 20)

        pokemonResponseCall.enqueue(object : Callback<PokemonResponse> {
            override fun onFailure(call: Call<PokemonResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<PokemonResponse>?, response: Response<PokemonResponse>?) {
                sePuedeCargar = true
                if(response!!.isSuccessful) {




                }
            }
        })

    }

}