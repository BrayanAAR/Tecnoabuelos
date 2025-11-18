package com.example.tecnoabuelos.view.Home.lecciones.tiktok

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.view.core.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Tiktok(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val username by homeViewModel.username.collectAsState()
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall
    val titleLargeStyle = MaterialTheme.typography.titleLarge

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Tiktok", style = headlineSmallStyle)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver al menú anterior",
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
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (!username.isNullOrEmpty()) {
                Text(
                    text = "Muy bien $username, Selecciona una lección para empezar",
                    style = headlineSmallStyle.copy(fontSize = titleLargeStyle.fontSize),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            ButtonLesson(navController, Screens.DescargarTiktok.route, "¿Cómo se descarga Tiktok?", titleLargeStyle)
            ButtonLesson(navController, Screens.NavegacionBasicaTiktok.route, "Conoce más de Tiktok", titleLargeStyle)
            ButtonLesson(navController, Screens.CrearCuentaTiktok.route, "¿Cómo se crea una cuenta de Tiktok?", titleLargeStyle)

            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 60.dp)
            ) {
                Text("<- VOLVER AL MENÚ", style = titleLargeStyle)
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

@Composable
fun ButtonLesson(
    navController: NavHostController,
    route: String,
    text: String,
    textStyle: androidx.compose.ui.text.TextStyle
) {
    Button(
        onClick = { navController.navigate(route) },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 70.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(text, style = textStyle, maxLines = 2, textAlign = TextAlign.Center)
    }
    Spacer(modifier = Modifier.height(20.dp))
}