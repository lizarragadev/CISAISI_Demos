package com.miramicodigo.restful1.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.miramicodigo.restful1.model.PokemonResponse

interface PokeInterface {
    @GET("pokemon")
    fun obtenerListaPokemon(
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
    ): Call<PokemonResponse>
}