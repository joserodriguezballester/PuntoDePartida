package com.example.esqueleto.ui.screens.pokemonDetail

import com.example.esqueleto.Utils.Resource
import com.example.esqueleto.api.Repository
import com.example.esqueleto.data.modelsResponses.Pokemon
import com.example.esqueleto.data.response.Pokemon2
import kotlinx.coroutines.delay

class PokemonDetailViewModel(private val repository: Repository) {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon2> {
        return repository.getPokemonInfo(pokemonName)
    }

}
