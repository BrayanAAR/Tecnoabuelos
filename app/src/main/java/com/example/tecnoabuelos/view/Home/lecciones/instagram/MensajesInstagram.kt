package com.example.tecnoabuelos.view.Home.lecciones.instagram

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
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
fun MensajesInstagram(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
){
    val username = homeViewModel.username.collectAsState().value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("Mensajes en Instagram", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "1. Para ver tus mensajes, toca el ícono de una burbuja con un rayo (arriba a la derecha).\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram22),
            contentDescription = "Icono mensajes",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "2. Aquí verás las conversaciones con otras personas.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram23),
            contentDescription = "Lista de mensajes",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "3. Toca una conversación para abrirla. Escribe tu mensaje abajo.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram24),
            contentDescription = "Conversación abierta",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "4. Para enviar una foto, toca el icono de la cámara dentro del chat.\n",
            fontSize = 22.sp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_instagram25),
            contentDescription = "Icono de foto",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Muy bien! Ya sabes enviar mensajes directos. Ahora podrás conversar con tus seres queridos en cualquier momento. ¡Felicidades!"
            else
                "¡Felicitaciones $username, Ya sabes enviar mensajes directos. Ahora podrás conversar con tus seres queridos en cualquier momento.!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
