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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens
import kotlinx.coroutines.launch

// Importaciones necesarias para el botón de edición
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    val temaOscuro by homeViewModel.temaOscuro.collectAsState()
    val username by homeViewModel.username.collectAsState()
    var nombreTemp by remember { mutableStateOf(username ?: "") }
    val nombreGuardado = username.isNullOrEmpty().not()

    // Controla si se está en modo edición de nombre
    var isEditingName by remember { mutableStateOf(!nombreGuardado) }

    val opciones = listOf(
        R.drawable.ic_redessociales to "Redes Sociales",
        R.drawable.ic_aplicacionessistema to "Aplicaciones del Sistema",
    )

    val bodyLargeStyle = MaterialTheme.typography.bodyLarge
    val titleLargeStyle = MaterialTheme.typography.titleLarge
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "TECNOABUELOS",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(30.dp))

            // --- SECCIÓN: INGRESO/EDICIÓN DE NOMBRE ---
            if (isEditingName) {
                OutlinedTextField(
                    value = nombreTemp,
                    onValueChange = { nombreTemp = it },
                    label = { Text("Escribe tu nombre aquí", style = bodyLargeStyle) },
                    placeholder = { Text("Ej. Elena", style = bodyLargeStyle) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = bodyLargeStyle,
                    singleLine = true
                )
                Button(
                    onClick = {
                        scope.launch {
                            homeViewModel.setUsername(nombreTemp)
                            isEditingName = false // Desactiva la edición
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp)
                        .padding(vertical = 10.dp),
                    enabled = nombreTemp.isNotBlank()
                ) {
                    Text("GUARDAR MI NOMBRE", style = titleLargeStyle)
                }
                Spacer(modifier = Modifier.height(20.dp))
            } else {
                // --- SECCIÓN: SALUDO Y BOTÓN DE EDICIÓN ---
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Pregunta principal, con el nombre
                    Text(
                        text = "$username, ¿qué quieres aprender hoy?",
                        style = headlineSmallStyle,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f) // Ocupa el espacio restante
                    )

                    // Botón para volver a editar el nombre
                    IconButton(
                        onClick = {
                            isEditingName = true // Activar la edición
                            nombreTemp = username ?: ""
                        },
                        modifier = Modifier.size(56.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Cambiar nombre",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
                Spacer(Modifier.height(30.dp))
            }

            // --- SECCIÓN: MODO OSCURO (Solo visible si NO se está editando) ---
            if (!isEditingName) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp)
                ) {
                    Text("Modo oscuro", style = bodyLargeStyle, modifier = Modifier.weight(1f))
                    Switch(
                        checked = temaOscuro,
                        onCheckedChange = { scope.launch { homeViewModel.setTemaOscuro(it) } }
                    )
                }

                Divider()
                Spacer(Modifier.height(30.dp))
            }


            // --- SECCIÓN: MÓDULOS (Solo visible si NO se está editando) ---
            if (!isEditingName) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(8.dp)
                ) {
                    items(opciones) { (imagen, texto) ->
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            shadowElevation = 4.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    when (texto) {
                                        "Redes Sociales" -> navController.navigate(Screens.RedesSociales.route)
                                        "Aplicaciones del Sistema" -> navController.navigate(Screens.AplicacionesSistema.route)
                                    }
                                }
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(vertical = 20.dp, horizontal = 8.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = imagen),
                                    contentDescription = texto,
                                    modifier = Modifier.size(140.dp)
                                )
                                Spacer(modifier = Modifier.height(16.dp))
                                Text(
                                    texto,
                                    style = titleLargeStyle
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}