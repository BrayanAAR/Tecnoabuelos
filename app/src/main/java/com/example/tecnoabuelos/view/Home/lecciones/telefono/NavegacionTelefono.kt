package com.example.tecnoabuelos.view.Home.lecciones.telefono

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
fun NavegacionTelefono(
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
        Text("Navegación Básica de Contactos", style = headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        // -------- PASO 0 --------
        Text("Primero se busca la aplicacion 'Telefono' en tu pantalla.\n", style = headlineSmallStyle)
        Image(
            painter = painterResource(id = R.drawable.ic_telefono0),
            contentDescription = "Icono de telefono",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        // -------- PASO 1 --------
        Text("Teclado.\n", style = headlineSmallStyle)
        Text(
            "1. En esta seccion podras digitar el numero de otra persona.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono1),
            contentDescription = "Teclado",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "Una vez digitado el numero podras llamar a la otra persona presionando el boton verde de la parte inferior.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono2),
            contentDescription = "icono de verde",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Spacer(modifier = Modifier.height(20.dp))


        // -------- PASO 2 --------
        Text("Recientes.\n", style = headlineSmallStyle)

        Text(
            "2. en este apartado podras ver el historial de llamadas realizadas, rechazadas o perdidas.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono3),
            contentDescription = "Llamadas Recientes",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Spacer(modifier = Modifier.height(20.dp))


        // -------- PASO 3 --------
        Text("Contactos.\n", style = headlineSmallStyle)

        Text(
            "3. En contactos podras ver todos los numeros guardados en el telefono y su infromacion si los presionas.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono4),
            contentDescription = "Contactos",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_telefono7),
            contentDescription = "Contactos desplegados",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "En esta misma parte si presionas la lupa de la parte superior, " +
                    "Podras buscar por el nombre de la persona que quieras para una busqueda mas rapida.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono5),
            contentDescription = "Lupa de contactos  ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))
        Text(
            "Ademas si presionas el + de la parte superior, " +
                    "Podras Agregar un nuevo contacto en el telefono.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono6),
            contentDescription = "+ de contactos  ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_telefono8),
            contentDescription = "+ de contactos  ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.ic_telefono9),
            contentDescription = "+ de contactos  ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )







        Spacer(modifier = Modifier.height(25.dp))
        Spacer(modifier = Modifier.height(20.dp))

        // -------- MENSAJE FINAL --------
        Text(
            text =
                if (username.isNullOrEmpty())
                    "¡Excelente! Ya sabes usar lo básico de Contactos. Ahora puedes llamar a tus familiares o amigos. ¡Felicidades!"
                else
                    "¡Muy bien $username! Ya sabes usar lo básico de Contactos. Ahora puedes llamar a tus familiares o amigos. ¡Sigue así!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}