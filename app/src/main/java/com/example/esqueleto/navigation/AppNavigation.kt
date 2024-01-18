package com.example.esqueleto.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.esqueleto.api.Repository
import com.example.esqueleto.ui.screens.HomeScreen
import com.example.esqueleto.ui.screens.pokemonDetail.PokemonDetailScreen
import com.example.esqueleto.ui.screens.pokemonList.PokemonListScreen
import com.example.esqueleto.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController, repository: Repository) {

    NavHost(
        navController = navController,
        startDestination = Routes.PokemonListScreen.route
    ) {
        composable(Routes.WelcomeScreen.route) {
            WelcomeScreen(navController = navController)
        }
        composable(Routes.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(Routes.PokemonListScreen.route) {
            PokemonListScreen(navController = navController, repository = repository)
        }

        composable(
            route = "pokemon_detail_screen/{dominantColor}/{pokemonName}",
            //    route = Routes.PokemonDetailScreen.route,
            arguments = listOf(
                navArgument("dominantColor") { type = NavType.IntType },
                navArgument("pokemonName") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val dominantColor = remember {
                // Recupera el valor del argumento "entry" del backStackEntry
                backStackEntry.arguments?.getInt("dominantColor")
            }
            requireNotNull(dominantColor)

            val pokemonName = remember {
                backStackEntry.arguments?.getString("pokemonName")
            }
            requireNotNull(pokemonName)
            PokemonDetailScreen(navController = navController, dominantColor, pokemonName,repository)
        }
    }
}


