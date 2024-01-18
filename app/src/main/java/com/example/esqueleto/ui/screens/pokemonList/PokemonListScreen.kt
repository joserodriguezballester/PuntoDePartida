package com.example.esqueleto.ui.screens.pokemonList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.esqueleto.R
import com.example.esqueleto.api.Repository
import com.example.esqueleto.data.models.PokedexListEntry
import com.github.satoshun.compose.palette.coil.rememberCoilPaletteState

@Composable
fun PokemonListScreen(navController: NavController, repository: Repository) {
    val viewModel: PokemonListViewModel = PokemonListViewModel(repository)

    //   val pokemonList by remember { viewModel.pokemonList }
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterHorizontally)
            )
            DibujarPokemonList(viewModel, navController)
        }
    }
}

@Composable
fun DibujarPokemonList(viewModel: PokemonListViewModel, navController: NavController) {
    val pokemonList by remember { viewModel.pokemonList }
    val endReached by remember { viewModel.endReached }
    val loadError by remember { viewModel.loadError }
    val isLoading by remember { viewModel.isLoading }

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        val itemCount = if (pokemonList.size % 2 == 0) {
            pokemonList.size / 2
        } else {
            pokemonList.size / 2 + 1
        }
        items(itemCount) {
            if (it >= itemCount - 1 && !endReached) {
                viewModel.loadPokemonPaginated()
            }
            PokedexRow(
                rowIndex = it,
                entries = pokemonList,
                navController = navController
            )
        }
    }
}

@Composable
fun PokedexRow(
    rowIndex: Int,
    entries: List<PokedexListEntry>,
    navController: NavController,
) {

    Column {
        Row {
            PokedexEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f),
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                PokedexEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun PokedexEntry(
    entry: PokedexListEntry,
    navController: NavController,
    modifier: Modifier,
) {

    // Para dar color de fondo
    val paletteState = rememberCoilPaletteState(data = entry.imageUrl)
    // evitar que defaultDominantColor sea nulo
    val defaultDominantColor = paletteState.dominant ?: MaterialTheme.colorScheme.primary
    val dominantColor by remember { mutableStateOf(defaultDominantColor) }

    Column(
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                val newColor= dominantColor.toArgb()
                val selectPokemonName=entry.pokemonName

                navController.navigate(
                    route = "pokemon_detail_screen/${newColor}/${selectPokemonName}"
              // route=   Routes.PokemonDetailScreen.createRoute(newColor,selectPokemonName)
                    )
            },

        horizontalAlignment = CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(entry.imageUrl)
                .crossfade(true)
                .build(),
            // placeholder = painterResource(R.drawable.placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .height(70.dp)
                .weight(9f)
                .fillMaxWidth()
        )

        Text(
            text = entry.pokemonName,
            //  fontFamily = RobotoCondensed,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
        )
    }
}



