package com.example.tecnoabuelos.view.Home.lecciones.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.view.core.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoriasInstagram(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "¿Cómo se suben historias?",
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
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            Spacer(modifier = Modifier.height(20.dp))


            // Paso 1
            Text(
                "1. En tu pantalla principal, toca tu foto con el símbolo “+” para crear una Historia.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_instagram26),
                contentDescription = "Icono para crear historia",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            // Paso 2
            Text(
                "2. Se abrirá la cámara. Puedes tomar una foto o grabar un video manteniendo presionado el botón blanco del centro.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_instagram27),
                contentDescription = "Pantalla de cámara",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            // Paso 3
            Text(
                "3. También puedes deslizar hacia arriba para elegir una foto o video que ya tengas en tu teléfono.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_instagram28),
                contentDescription = "Galería",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            // Paso 4
            Text(
                "4. Puedes agregar texto, dibujos o stickers antes de publicar tu Historia.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_instagram29),
                contentDescription = "Herramientas de edición",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            // Paso 5
            Text(
                "5. Cuando estés listo, toca “Tu historia” para publicarla. Durará 24 horas.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_instagram30),
                contentDescription = "Publicar historia",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))


            // Mensaje final personalizable
            Text(
                text = if (username.isNullOrEmpty())
                    "¡Excelente! Ya sabes cómo subir Historias. Ahora podrás compartir tus momentos del día de manera rápida y divertida. ¡Muy bien hecho!"
                else
                    "¡Excelente $username! Ya sabes cómo subir Historias. Ahora podrás compartir tus momentos del día de manera rápida y divertida. ¡Muy bien hecho!",
                fontSize = 22.sp
            )


            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("← Volver al menú", fontSize = 20.sp)
            }
        }
    }
}
