package com.example.tecnoabuelos.view.Home.lecciones.aplicacionesSistema

import com.example.tecnoabuelos.view.Home.HomeViewModel
import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens
import com.example.tecnoabuelos.data.datastore.PreferencesRepository
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AplicacionesSistema(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val temaOscuro by homeViewModel.temaOscuro.collectAsState()
    val username by homeViewModel.username.collectAsState()
    var nombreTemp by remember { mutableStateOf(username ?: "") }


    val opciones = listOf(
        R.drawable.ic_galeria to "Galeria",
        R.drawable.ic_reloj to "Reloj",
        R.drawable.ic_camara to "Camara",

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("TECNOABUELOS", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¿Qué quieres aprender hoy?"
            else
                "$username, ¿qué quieres aprender hoy?",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Cuadrícula 2xN
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(opciones) { (imagen, texto) ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(12.dp)
                        .clickable {
                            when (texto) {
                                "Galeria" -> navController.navigate(Screens.Galeria.route)
                                "Reloj" -> navController.navigate(Screens.Alarma.route)
                                "Camara" -> navController.navigate(Screens.Camara.route)

                            }
                        }
                ) {
                    Image(
                        painter = painterResource(id = imagen),
                        contentDescription = texto,
                        modifier = Modifier.size(120.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(texto, fontSize = 20.sp)
                }
            }
        }
    }
}
