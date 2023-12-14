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
fun HomeScreen(navController: NavHostController) {
    Log.i("MyTag","Home")
    var modifier = Modifier.padding(16.dp)
    Greeting2(name = "Home", modifier,navController)

}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier, navController: NavHostController) {
    Text(
        text = "Hello $name!",
        modifier = modifier
          .clickable {
            navController.navigate(Routes.DetailScreen.route)
        }
    )



}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    NavegacionBasicaTheme {
//        Greeting("Android", navController = navController)
//    }
//}