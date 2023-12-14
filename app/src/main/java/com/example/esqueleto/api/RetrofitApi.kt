package com.example.esqueleto.api

import com.example.esqueleto.remote.modelsResponses.Pokemon
import com.example.esqueleto.remote.modelsResponses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Estructura de las peticiones del servidor
 */
interface RetrofitApi {

 @GET("pokemon")
 suspend fun getPokemonList(
  @Query("limit") limit: Int,
  @Query("offset") offset: Int
 ): PokemonList

 @GET("pokemon/{name}")
 suspend fun getPokemonInfo(
  @Path("name") name: String
 ): Pokemon
    
}