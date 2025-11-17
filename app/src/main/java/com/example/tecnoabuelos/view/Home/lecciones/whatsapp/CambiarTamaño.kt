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
fun CambiarTamaño(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
)  {
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
        Text("Cómo cambiar el tamaño de la letra en WhatsApp", style=headlineSmallStyle)
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
        Text("3. Busca los tres puntitos de la parte superior. Al presionarlos debera aparecer un menu como este:\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp2),
            contentDescription = "Menu desplegado tres puntitos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. Selecciona la opcion que dice ajustes\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp3),
            contentDescription = "Menu desplegado tres puntitos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("5. Selecciona la opcion que dice ' Chats'.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp24),
            contentDescription = "Chats ajustes en rojo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("6. Selecciona la opcion 'Tamaño de fuente'. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp25),
            contentDescription = "'Tamaño de fuente' en rojo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("7. Elige el tamaño que mas te acomode y presiona 'Ok'. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp26),
            contentDescription = "Opciones cambio letra",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por cambiar tu el tamaño de la letra!"
            else
                "¡Felicitaciones $username, por cambiar tu el tamaño de la letra!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
