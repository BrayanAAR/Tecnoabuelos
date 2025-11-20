package com.example.tecnoabuelos.view.Home.lecciones.whatsapp

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescargaWhatsapp(
    navController: NavHostController,
     homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("¿Cómo se descarga WhatsApp?", style = headlineSmallStyle, textAlign = TextAlign.Center)
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

            Text("1. Busca el siguiente ícono de la PlayStore en tu teléfono.\n", fontSize = 22.sp)

            Image(
                painter = painterResource(id = R.drawable.ic_playstore),
                contentDescription = "Icono de Playstore",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_playstore1),
                contentDescription = "PlayStore abierto",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text("3. Busca la lupa de la parte inferior con el nombre 'Buscar', presionala y escribe 'Whatsapp'.\n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp22),
                contentDescription = "Escribiendo en el buscdor de la playstore",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "4. Al buscar la aplicación, y seleccionar 'WhatsApp' entre las búsquedas, se muestra " +
                        "la aplicacion para descargar. Luego presiona en 'Instalar' y se empezará a descargar e instalar, tal y como se muestra en la siguiente imagen.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_playstorewhatsapp),
                contentDescription = "Descargando app",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "5. Una vez realizado todos estos pasos, ya tendrás la aplicación descargada en tu teléfono\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp0),
                contentDescription = "Pantalla con wsp en rojo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = if (username.isNullOrEmpty())
                    "¡Felicitaciones por descargar WhatsApp!"
                else
                    "¡Felicitaciones $username por descargar WhatsApp!",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("← Volver al menú", fontSize = 20.sp)
            }
        }
    }
}