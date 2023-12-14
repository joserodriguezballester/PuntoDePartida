package com.example.esqueleto.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.esqueleto.navigation.Routes

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Log.i("MyTag", "Welcome")
    val modifier = Modifier.padding(16.dp)
    Greeting(name = "Welcome", modifier, navController)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, navController: NavHostController) {
    Text(
        text = "Hello $name!",
        modifier = modifier.clickable {
            Log.i("MyTag", "pulsado")
            navController.navigate(Routes.HomeScreen.route)
        })

}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    NavegacionBasicaTheme {
//        Greeting("Android", navController = navController)
//    }
//}