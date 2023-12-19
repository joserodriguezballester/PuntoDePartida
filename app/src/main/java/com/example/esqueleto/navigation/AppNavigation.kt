package com.example.esqueleto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.esqueleto.api.Repository
import com.example.esqueleto.ui.screens.HomeScreen
import com.example.esqueleto.ui.screens.PokemonListScreen
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
        composable(Routes.DetailScreen.route) {
            //       DetailScreen(navController = navController)
        }
        composable(Routes.PokemonListScreen.route){
            PokemonListScreen(navController = navController, repository = repository)
        }
    }
}


