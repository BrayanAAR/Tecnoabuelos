package com.example.tecnoabuelos.view.Home.lecciones.telefono

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.ButtonLesson
import com.example.tecnoabuelos.view.core.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Telefono(navController: NavHostController,homeViewModel: HomeViewModel = viewModel()
) {
    val username by homeViewModel.username.collectAsState()
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall
    val titleLargeStyle = MaterialTheme.typography.titleLarge

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Telefono", style = headlineSmallStyle)
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
        ){
            if (!username.isNullOrEmpty()) {
                Text(
                    text = "$username, elige una lección:",
                    style = headlineSmallStyle.copy(fontSize = titleLargeStyle.fontSize),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            ButtonLesson(navController, Screens.NavegacionTelefono.route, "Como navegar por los contactos", titleLargeStyle)
            //ButtonLesson(navController, Screens.CrearCuentaInstagram.route, "Como marcar a un contacto", titleLargeStyle)
            //ButtonLesson(navController, Screens.OpcionPerfilInstagram.route, "como guardar un contacto", titleLargeStyle)
            //ButtonLesson(navController, Screens.PublicarInstagram.route, "Como ver el registro de llamadas", titleLargeStyle)
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
        Text(text, style = textStyle, maxLines = 2)
    }
    Spacer(modifier = Modifier.height(20.dp))
}