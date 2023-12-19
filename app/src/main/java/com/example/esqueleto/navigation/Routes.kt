package com.example.esqueleto.navigation

sealed class Routes (val route: String){
    object WelcomeScreen : Routes(route = "welcome")
    object HomeScreen : Routes(route = "home")
    object DetailScreen :Routes(route="detail")
    object PokemonListScreen :Routes(route="pokemonList")
}