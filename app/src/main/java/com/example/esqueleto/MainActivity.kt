package com.example.esqueleto

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.esqueleto.di.RetrofitApiFactory
import com.example.esqueleto.navigation.AppNavigation
import com.example.esqueleto.ui.theme.NavegacionBasicaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val service = RetrofitApiFactory.provideRetrofitApi()

        lifecycleScope.launch {
            val myPokemonList = service.getPokemonList(0, 0)
            Log.i("MyTag", myPokemonList.toString())
        }

        setContent {
            NavegacionBasicaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    AppNavigation(navController = navController)

                    //    Greeting("Android")
                }
            }
        }
    }
}

