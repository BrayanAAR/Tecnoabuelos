package com.example.tecnoabuelos.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val scope = rememberCoroutineScope()
    val temaOscuro by homeViewModel.temaOscuro.collectAsState()
    val username by homeViewModel.username.collectAsState()
    var nombreTemp by remember { mutableStateOf(username ?: "") }
    var isEditingName by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }

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
                },
                actions = {
                    IconButton(onClick = { showMenu = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Ajustes")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Cambiar nombre") },
                            onClick = {
                                isEditingName = true
                                nombreTemp = username ?: ""
                                showMenu = false
                            }
                        )
                    }
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
            Spacer(Modifier.height(16.dp))

            if (isEditingName) {
                // --- SECCIÓN DE EDICIÓN ---
                OutlinedTextField(
                    value = nombreTemp,
                    onValueChange = { nombreTemp = it },
                    label = { Text("Cambia tu nombre", style = bodyLargeStyle) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = bodyLargeStyle,
                    singleLine = true
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedButton(
                        onClick = { isEditingName = false },
                        modifier = Modifier.weight(1f).heightIn(min = 56.dp)
                    ) {
                        Text("CANCELAR", style = titleLargeStyle)
                    }
                    Button(
                        onClick = {
                            scope.launch {
                                homeViewModel.setUsername(nombreTemp)
                                isEditingName = false
                            }
                        },
                        modifier = Modifier.weight(1f).heightIn(min = 56.dp),
                        enabled = nombreTemp.isNotBlank()
                    ) {
                        Text("GUARDAR", style = titleLargeStyle)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
            } else {
                // --- VISTA PRINCIPAL ---
                Text(
                    text = if (!username.isNullOrEmpty()) "$username, ¿qué quieres aprender hoy?" else "¿Qué quieres aprender hoy?",
                    style = headlineSmallStyle,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(24.dp))

                // Switch de Modo Oscuro
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
                Spacer(Modifier.height(24.dp))

                // Módulos de aprendizaje
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    contentPadding = PaddingValues(bottom = 16.dp)
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
                                Text(texto, style = titleLargeStyle)
                            }
                        }
                    }
                }
            }
        }
    }
}