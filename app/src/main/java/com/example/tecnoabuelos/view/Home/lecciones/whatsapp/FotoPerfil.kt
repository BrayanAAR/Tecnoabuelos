package com.example.tecnoabuelos.view.Home.lecciones.whatsapp

import androidx.compose.foundation.Image
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
fun FotoPerfil(
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
                        "¿Cómo se cambia la foto de perfil?",
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

            Text("1. Busca el siguiente ícono WhatsApp de en tu teléfono.\n", fontSize = 22.sp)

            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp0),
                contentDescription = "Icono de whatsapp",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n",
                fontSize = 22.sp
            )

            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp1),
                contentDescription = "Whatsapp abierta",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "3. Busca los tres puntitos de la parte superior. Al presionarlos debera aparecer un menu como este:\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp2),
                contentDescription = "Menu desplegado tres puntitos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text("4. Selecciona la opción que dice 'Ajustes'\n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp3),
                contentDescription = "Menu desplegado tres puntitos",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "5. Presiona sobre tú foto de perfil (Si no tienes, presiona sobre el circulo blanco)\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp4),
                contentDescription = "foto en rojo",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text("6. Presionar 'Editar' que se encuentra debajo de la foto \n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp5),
                contentDescription = "Editar debajo de la foto",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("7. Existen dos opciones para escoger una nueva foto. \n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp11),
                contentDescription = "Opciones cambio",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Text(
                "La primera opción, es buscar una foto existente en la galería  \n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp6),
                contentDescription = "Fotos de la galeria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text("Buscamos la foto deseada y la seleccionamos. \n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp7),
                contentDescription = "Fotos de la galeria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text("La segunda opción, es tomar una foto con la cámara.  \n", fontSize = 22.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp10),
                contentDescription = "Opcion de camara",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text("Tomamos una foto con la cámara. \n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp12),
                contentDescription = "Fotos de la galeria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "8. En cualquiera de las dos opciones, tendremos la posibilidad de ajustar la foto. El espacio marcado indica lo que la aplicación usará para la foto de perfil. \n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp8),
                contentDescription = "Ajuste de la foto",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "9. Si se ha echo todo correcto debera aparecer un mensaje de 'Se ha actualizado " +
                        "la foto de perfil' y se visualizará la nueva foto.  \n", fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp9),
                contentDescription = "Fotos de la galeria",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = if (username.isNullOrEmpty())
                    "¡Felicitaciones por cambiar tu foto de perfil!"
                else
                    "¡Felicitaciones $username por cambiar tu foto de perfil!",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("← Volver al menú", fontSize = 20.sp)
            }
        }
    }
}