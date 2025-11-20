package com.example.tecnoabuelos.view.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var nombreTemp by remember { mutableStateOf("") }
    var isEditingName by remember { mutableStateOf(false) }
    var showMenu by remember { mutableStateOf(false) }

    val opciones = listOf(
        R.drawable.ic_redessociales to "Redes Sociales",
        R.drawable.ic_aplicacionessistema to "Aplicaciones del Sistema",
    )

    LaunchedEffect(username) {
        nombreTemp = username ?: ""
    }


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Spacer(modifier = Modifier.width(12.dp))

                        Text(
                            text = "TecnoAbuelos",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = androidx.compose.ui.text.font.FontFamily.SansSerif,
                            letterSpacing = 1.sp,
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black.copy(alpha = 0.3f),
                                    offset = Offset(4f, 4f),
                                    blurRadius = 8f
                                )
                            )
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                actions = {
                    IconButton(onClick = {
                        scope.launch { homeViewModel.setTemaOscuro(!temaOscuro) }
                    }) {
                        Icon(
                            imageVector = if (temaOscuro) Icons.Default.DarkMode else Icons.Default.LightMode,
                            contentDescription = "Alternar modo oscuro",
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Box {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(
                                Icons.Default.MoreVert,
                                contentDescription = "Ajustes",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        "Cambiar mi nombre",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                },
                                leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
                                onClick = {
                                    showMenu = false
                                    isEditingName = true

                                }
                            )
                        }
                    }
                }
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (isEditingName) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "¿Cómo te llamas?",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            value = nombreTemp,
                            onValueChange = { nombreTemp = it },
                            label = { Text("Escribe tu nombre aquí", fontSize = 18.sp) },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            textStyle = LocalTextStyle.current.copy(fontSize = 24.sp) // Texto que escriben
                        )

                        Spacer(modifier = Modifier.height(30.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            OutlinedButton(
                                onClick = { isEditingName = false },
                                modifier = Modifier.weight(1f).height(60.dp)
                            ) {
                                Text("Cancelar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            }
                            Button(
                                onClick = {
                                    scope.launch {
                                        homeViewModel.setUsername(nombreTemp)
                                        isEditingName = false
                                    }
                                },
                                modifier = Modifier.weight(1f).height(60.dp),
                                enabled = nombreTemp.isNotBlank()
                            ) {
                                Text("Guardar", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

            } else {

                // SALUDO
                Text(
                    text = if (!username.isNullOrEmpty()) "¡Hola, $username!" else "¡Hola!",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = if (temaOscuro) MaterialTheme.colorScheme.onSurface else Color.Black
                )

                Text(
                    text = "¿Qué quieres hacer hoy?",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    color = if (temaOscuro) Color.LightGray else Color.Gray
                )

                Spacer(modifier = Modifier.height(30.dp))


                // --- AQUÍ ESTÁ LA GRILLA CON ICONOS GIGANTES (Igual a Redes Sociales) ---
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    items(opciones) { (imagen, texto) ->
                        Card(
                            shape = RoundedCornerShape(20.dp),

                            elevation = CardDefaults.cardElevation(6.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White), // Fondo Blanco
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
                                modifier = Modifier
                                    .padding(vertical = 24.dp, horizontal = 8.dp)
                                    .fillMaxWidth()
                            ) {
                                // IMAGEN GIGANTE (Igual que en Redes Sociales)
                                Image(
                                    painter = painterResource(id = imagen),
                                    contentDescription = texto,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier.size(140.dp) // Aumentado a 140.dp
                                )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = texto,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                    lineHeight = 24.sp,
                                    color = Color.Black,
                                    minLines = 2, // Fuerza a que el texto siempre ocupe el alto de 2 líneas
                                    maxLines = 2, // Evita que crezca más de 2 líneas
                                    overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis // Pone "..." si se pasa
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}