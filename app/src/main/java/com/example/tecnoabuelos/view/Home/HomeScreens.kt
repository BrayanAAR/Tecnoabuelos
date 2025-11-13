package com.example.tecnoabuelos.view.Home

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
fun HomeScreens(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val temaOscuro by homeViewModel.temaOscuro.collectAsState()
    val username by homeViewModel.username.collectAsState()
    var nombreTemp by remember { mutableStateOf(username ?: "") }


    val opciones = listOf(
        R.drawable.ic_whatsapp to "WhatsApp",
        R.drawable.ic_galeria to "Internet",
        R.drawable.ic_instagram to "Instagram",
        R.drawable.ic_facebook to "Facebook",
        //R.drawable.ic_tiktok to "Tiktok",
        R.drawable.ic_galeria to "Galería",
        R.drawable.ic_reloj to "Reloj",
//        R.drawable.ic_camara to "Cámara",
//        R.drawable.ic_contactos to "Contactos",
//        R.drawable.ic_galeria to "Sonido",
//        R.drawable.ic_galeria to "Notificaciones",
//        R.drawable.ic_buscador to "Buscador",



    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text("TECNOABUELOS", fontSize = 32.sp)
        Spacer(modifier = Modifier.height(10.dp))

        // Campo para ingresar el nombre del usuario
        OutlinedTextField(
            value = nombreTemp,
            onValueChange = { nombreTemp = it },
            label = { Text("Ingrese aquí su nombre") },
            modifier = Modifier.fillMaxWidth(10f)
        )

        Button(
            onClick = {
                scope.launch {
                    homeViewModel.setUsername(nombreTemp)
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Guardar nombre")
        }


        Spacer(modifier = Modifier.height(10.dp))

        // Switch para tema oscuro
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Modo oscuro", fontSize = 18.sp)
            Switch(
                checked = temaOscuro,
                onCheckedChange = {
                    scope.launch {
                        homeViewModel.setTemaOscuro(it)
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
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
                                "Galería" -> navController.navigate(Screens.Galeria.route)
                                "Reloj" -> navController.navigate(Screens.Alarma.route)
                                "Buscador" -> navController.navigate(Screens.Buscador.route)
                                "WhatsApp" -> navController.navigate(Screens.Whatsapp.route)
                                "Instagram" -> navController.navigate(Screens.Instagram.route)
                                "Facebook" -> navController.navigate(Screens.Facebook.route)
                                "Contactos" -> navController.navigate(Screens.Contactos.route)
                                "Cámara" -> navController.navigate(Screens.Camara.route)
                                "Sonido" -> navController.navigate(Screens.Sonido.route)
                                "Notificaciones" -> navController.navigate(Screens.Notificaciones.route)
                                "Internet" -> navController.navigate(Screens.Interner.route)
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
