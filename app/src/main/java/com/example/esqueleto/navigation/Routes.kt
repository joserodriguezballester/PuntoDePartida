package com.example.esqueleto.navigation

sealed class Routes (val route: String){
    object WelcomeScreen : Routes(route = "welcome")
    object HomeScreen : Routes(route = "home")


    object PokemonListScreen :Routes(route="pokemonList")

    // object PokemonDetailScreen :Routes(route="pokemonDetail/{dominantColor}/{pokemonName}")
    object PokemonDetailScreen {
        const val route = "pokemon_detail_screen/{pokemonId}/{pokemonName}"

        fun createRoute(pokemonId: Int, pokemonName: String): String {
            return "pokemon_detail_screen/$pokemonId/$pokemonName"
        }
    }
}