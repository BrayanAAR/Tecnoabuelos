package com.example.tecnoabuelos.view.Home.lecciones.redesSociales

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import kotlinx.coroutines.launch

private val ICON_SIZE = 140.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RedesSociales(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val username by homeViewModel.username.collectAsState()
    val opciones = listOf(
        R.drawable.ic_whatsapp to "WhatsApp",
        R.drawable.ic_instagram to "Instagram",
        R.drawable.ic_facebook to "Facebook",
        R.drawable.ic_tiktok to "Tiktok",
        R.drawable.ic_internet to "Internet",
    )
    val headlineLargeStyle = MaterialTheme.typography.headlineLarge
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall
    val titleLargeStyle = MaterialTheme.typography.titleLarge

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Redes Sociales", style = headlineSmallStyle)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
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
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = if (username.isNullOrEmpty())
                    "Presiona la red social que deseas aprender:"
                else
                    "$username, presiona la red social que deseas aprender:",
                style = headlineSmallStyle,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Cuadrícula 2xN
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(20.dp), // Espaciado amplio
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
                                    "WhatsApp" -> navController.navigate(Screens.Whatsapp.route)
                                    "Instagram" -> navController.navigate(Screens.Instagram.route)
                                    "Facebook" -> navController.navigate(Screens.Facebook.route)
                                    "Tiktok" -> navController.navigate(Screens.Tiktok.route)
                                    "Internet" -> navController.navigate(Screens.Interner.route)
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
                                modifier = Modifier.size(ICON_SIZE)
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