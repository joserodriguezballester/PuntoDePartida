package com.example.esqueleto.api

import com.example.esqueleto.Utils.Resource
import com.example.esqueleto.data.modelsResponses.Pokemon
import com.example.esqueleto.data.modelsResponses.PokemonList
import com.example.esqueleto.data.response.Pokemon2

class Repository(val apiService: RetrofitApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            apiService.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon2> {
        val response = try {
            apiService.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

}