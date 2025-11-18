package com.example.tecnoabuelos.view.Home.lecciones.alarma

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Alarma(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall
    val titleLargeStyle = MaterialTheme.typography.titleLarge

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "Alarma",
                        style = headlineSmallStyle,
                        textAlign = TextAlign.Center
                    )
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
            ButtonLesson(navController, Screens.ProgramarAlarma.route, "¿Cómo se programa una alarma?", titleLargeStyle)
            ButtonLesson(navController, Screens.EliminarAlarma.route, "¿Cómo se elimina una alarma?", titleLargeStyle)

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