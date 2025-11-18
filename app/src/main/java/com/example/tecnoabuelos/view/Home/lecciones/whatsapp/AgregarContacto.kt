package com.example.tecnoabuelos.view.Home.lecciones.whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.Home.HomeViewModel

@Composable
fun AgregarContacto(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("Cómo Agregar un contacto desde un chat de WhatsApp", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el siguiente ícono WhatsApp en tu pantalla.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp0),
            contentDescription = "Icono de whatsapp",
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
            painter = painterResource(id = R.drawable.ic_whatsapp1),
            contentDescription = "Whatsapp abierta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("3. Busca y seleccion el Chat donde esta el contacto que deseas agregar.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp13),
            contentDescription = "Chat abierto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. Presiona 'Añadir contacto', como se muestra en la siguiente imagen.\n\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp14),
            contentDescription = "'Añadir contacto'",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "5. En el menu que se despliega se le puede cambiar el nombre y " +
                    "sincronizar con sus contactos del telefono\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp15),
            contentDescription = "Menu añadir contacto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text("6. Selecciona 'guardar' y deberia verse un mensaje 'Se ha guardado el contacto' \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp16),
            contentDescription = "Icono de WhatsApp",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por agregar ese contacto!"
            else
                "¡Felicitaciones $username, por agregar ese contacto!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
