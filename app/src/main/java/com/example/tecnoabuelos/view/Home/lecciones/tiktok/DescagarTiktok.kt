package com.example.tecnoabuelos.view.Home.lecciones.tiktok

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
fun DescargarTiktok(
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
        Text("Cómo descargar Tiktok", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el siguiente ícono de la PlayStore en tu pantalla.\n", fontSize = 22.sp)

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
        Text("3. Busca la lupa de la parte inferior y escribe 'Tiktok'.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_playstoretiktok1),
            contentDescription = "Escribiendo en el buscdor de la playstore",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. Una vez buscada la aplicacion en la PlayStore, se muestra " +
                "la aplicacion para descargar. Luego presiona en 'Instalar' como se muestra en la siguiente imagen.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_playstoretiktok2),
            contentDescription = "Descargando app",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "5. Una vez realizado todos estos pasos ya deberia aparecer la aplicacion descargada en tu pantalla\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok0),
            contentDescription = "Pantalla con wsp en rojo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por descargar Tiktok!"
            else
                "¡Felicitaciones $username, por descargar Tiktok!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
