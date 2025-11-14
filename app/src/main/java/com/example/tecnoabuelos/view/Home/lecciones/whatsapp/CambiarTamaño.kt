package com.example.tecnoabuelos.view.Home.lecciones.whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun CambiarTamaño(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text("📸 Cómo abrir la galería", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el siguiente ícono de la galería en tu pantalla.\n\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_galeria),
            contentDescription = "Icono de galería",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            "2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n\n",
            fontSize = 22.sp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_galeria1),
            contentDescription = "Galería abierta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("3. Desliza para ver tus fotos o videos y busca la deseada.\n\n", fontSize = 22.sp)

        Text("4. Presiona la foto o video deseado, como por ejemplo esta:\n\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_galeria2),
            contentDescription = "Ejemplo foto seleccionada",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            "5. Luego de seleccionar la foto o video deseado, presiona el siguiente ícono para compartir:\n\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.icono_enviar),
            contentDescription = "Icono de enviar",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text("6. Presiona el ícono de WhatsApp.\n\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_galeria3),
            contentDescription = "Icono de WhatsApp",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text("7. Presiona el contacto al que deseas enviar la foto o video.\n\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_galeria4),
            contentDescription = "Seleccionar contacto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por enviar ese recuerdo a tu contacto!"
            else
                "¡Felicitaciones $username, por enviar ese recuerdo a tu contacto!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
