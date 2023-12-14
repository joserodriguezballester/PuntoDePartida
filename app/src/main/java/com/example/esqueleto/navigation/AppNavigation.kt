package com.example.esqueleto.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.esqueleto.ui.screens.HomeScreen
import com.example.esqueleto.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Routes.WelcomeScreen.route
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
    }
}


