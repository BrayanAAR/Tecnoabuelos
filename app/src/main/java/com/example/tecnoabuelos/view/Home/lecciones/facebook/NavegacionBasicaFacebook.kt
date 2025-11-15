package com.example.tecnoabuelos.view.Home.lecciones.facebook

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
fun NavegacionBasicaFacebook(
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
        Text("Navegación Básica de Facebook", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        // -------- PASO 1 --------
        Text(
            "1. para vizualizar o para volver al inicio siempre puedes tocar el ícono de la casita en la parte inferior izquierda.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook13),
            contentDescription = "Icono de inicio",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // -------- PASO 2 --------
        Text(
            "2. Para ver contenido, presiona el icono de pelicula en la barra inferior.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook14),
            contentDescription = "icono de reels",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // -------- PASO 3 --------
        Text(
            "3. Para ver la solicitud de amistad de las demas persona presina las dos personas" +
                    " juntas que se encuentran en el medio en la parte inferior.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook15),
            contentDescription = "icono de solicitud de amistad",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "En esta misma parte si presionas la lupa de la parte superior, Podras buscar por el nombre de la persona o contenido que quieras .\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook18),
            contentDescription = "Home Buscador  ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_facebook19),
            contentDescription = "Buscador persona ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 4 --------
        Text(
            "4. Para visualizar su perfil presiona el botón de la parte inferior de una persona en un circulo.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook16),
            contentDescription = "Botón seguir",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 5 --------
        Text(
            "5. Para revisar las notificaciones, presiona en la campanita de la parte inferior.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook17),
            contentDescription = "Me gusta",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- MENSAJE FINAL --------
        Text(
            text =
                if (username.isNullOrEmpty())
                    "¡Excelente! Ya sabes usar lo básico de Facebook. Ahora puedes navegar, seguir personas y mas. ¡Felicidades!"
                else
                    "¡Muy bien $username! Ya sabes usar lo básico de Facebook. Ahora puedes navegar, seguir personas y mas. ¡Sigue así!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}