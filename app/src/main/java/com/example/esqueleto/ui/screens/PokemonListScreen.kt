package com.example.esqueleto.ui.screens
//import coil.compose.rememberImagePainter
//  import androidx.navigation.compose.navigate
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.esqueleto.R
import com.example.esqueleto.api.Repository
import com.example.esqueleto.data.models.PokedexListEntry
import com.github.satoshun.compose.palette.coil.rememberCoilPaletteState


// import com.google.accompanist.coil.CoilImage

//@Composable
//fun PokemonListScreen(navController: NavController, repository: Repository) {
//    val viewModel: PokemonListViewModel = PokemonListViewModel(repository)
//    Surface(
//        color = MaterialTheme.colorScheme.background,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column {
//            Spacer(modifier = Modifier.height(20.dp))
//            Image(
//                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
//                contentDescription = "Pokemon",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(CenterHorizontally)
//            )
////            SearchBar(
////                hint = "Search...",
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(16.dp)
////            ) {
////
////            }
//            Spacer(modifier = Modifier.height(16.dp))
//            PokemonList(navController = navController, viewModel)
//        }
//    }
//}


//    Box(
//        contentAlignment = Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        if (isLoading) {
//                 CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
//        }
////        if (loadError.isNotEmpty()) {
////            RetrySection(error = loadError) {
////                viewModel.loadPokemonPaginated()
////            }
////        }
//    }
//
//}
//
//@Composable
//fun PokedexEntry(
//    entry: PokedexListEntry,
//    navController: NavController,
//    modifier: Modifier = Modifier,
//    viewModel: PokemonListViewModel,
//
//    ) {
//    //   val defaultDominantColor = MaterialTheme.colors.surface
////    var dominantColor by remember {
////        mutableStateOf(defaultDominantColor)
////    }
//
//    Box(
//        contentAlignment = Center,
//        modifier = modifier
//            .shadow(5.dp, RoundedCornerShape(10.dp))
//            .clip(RoundedCornerShape(10.dp))
//            .aspectRatio(1f)
////            .background(
//////                Brush.verticalGradient(
//////                    listOf(
//////                        dominantColor,
//////                        defaultDominantColor
//////                    )
//////                )
////            )
////            .clickable {
////                navController.navigate(
////                    "pokemon_detail_screen/${dominantColor.toArgb()}/${entry.pokemonName}"
////                )
////            }
//    ) {
//        Column {
//            CoilImage(
//                request = ImageRequest.Builder(LocalContext.current)
//                    .data(entry.imageUrl)
////                    .target {
////                        viewModel.calcDominantColor(it) { color ->
////                            dominantColor = color
////                        }
////                    }
//                    .build(),
//                contentDescription = entry.pokemonName,
//                fadeIn = true,
//                modifier = Modifier
//                    .size(120.dp)
//                    .align(CenterHorizontally)
//            ) {
//                CircularProgressIndicator(
//                    color = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.scale(0.5f)
//                )
//            }
//            Text(
//                text = entry.pokemonName,
//                //  fontFamily = RobotoCondensed,
//                fontSize = 20.sp,
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//    }
//}
//
//@Composable
//fun PokedexRow(
//    rowIndex: Int,
//    entries: List<PokedexListEntry>,
//    navController: NavController,
//    viewModel: PokemonListViewModel
//) {
//    Column {
//        Row {
//            PokedexEntry(
//                entry = entries[rowIndex * 2],
//                navController = navController,
//                modifier = Modifier.weight(1f),
//                viewModel=viewModel
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            if (entries.size >= rowIndex * 2 + 2) {
//                PokedexEntry(
//                    entry = entries[rowIndex * 2 + 1],
//                    navController = navController,
//                    modifier = Modifier.weight(1f),
//                    viewModel = viewModel
//                )
//            } else {
//                Spacer(modifier = Modifier.weight(1f))
//            }
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
////@Composable
////fun RetrySection(
////    error: String,
////    onRetry: () -> Unit
////) {
////    Column {
////        Text(error, color = Color.Red, fontSize = 18.sp)
////        Spacer(modifier = Modifier.height(8.dp))
////        Button(
////            onClick = { onRetry() },
////            modifier = Modifier.align(CenterHorizontally)
////        ) {
////            Text(text = "Retry")
////        }
////    }
////}
//
//
//
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
    // Get Palette
    val url = entry.imageUrl
    val paletteState = rememberCoilPaletteState(data = url)
    var defaultDominantColor = paletteState.dominant
    if (defaultDominantColor == null) defaultDominantColor = MaterialTheme.colorScheme.primary
    val dominantColor by remember { mutableStateOf(defaultDominantColor) }

    Column(

        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    colors =
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            ),
        horizontalAlignment =CenterHorizontally
//            .clickable {
//                navController.navigate(
//                    "pokemon_detail_screen/${dominantColor.toArgb()}/${entry.pokemonName}"
//                )
//            }
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
                .weight(9f).fillMaxWidth()
        )

        Text(
            text = entry.pokemonName,
            //  fontFamily = RobotoCondensed,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(2f).fillMaxWidth()
        )
    }
}



