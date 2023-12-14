package com.example.esqueleto.remote.modelsResponses

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Result>
)