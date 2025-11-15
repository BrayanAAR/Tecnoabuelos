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
fun BuscadorInstagram(
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
        Text("Navegación Básica de Instagram", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        // -------- PASO 1 --------
        Text(
            "1. Para volver al inicio siempre puedes tocar el ícono de la casita en la parte inferior izquierda.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram31),
            contentDescription = "Icono de inicio",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // -------- PASO 2 --------
        Text(
            "2. Para buscar personas o contenido, presiona la lupa en la barra inferior.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram32),
            contentDescription = "Buscador",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "Luego escribe el nombre de la persona o contenido.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram33),
            contentDescription = "Buscador",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_instagram34),
            contentDescription = "Buscador",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 3 --------
        Text(
            "3. Para comenzar a seguir a una persona, entra a su perfil y presiona el botón 'Seguir'.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram35),
            contentDescription = "Botón seguir",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 4 --------
        Text(
            "4. Para indicar que te gusta una publicación, toca el corazón debajo de la foto.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram36),
            contentDescription = "Me gusta",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 5 --------
        Text(
            "5. Para comentar, presiona el ícono del globo de comentario y escribe tu mensaje.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram37),
            contentDescription = "Comentarios",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // -------- PASO 6 --------
        Text(
            "6. Para Compartir una publicación, toca el ícono de avionsito de papel debajo de la publicacion.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram39),
            contentDescription = "Compartir",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- PASO 7 --------
        Text(
            "7. Para guardar una publicación y verla más tarde, toca el ícono de banderita en la esquina inferior derecha de la publicación.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram38),
            contentDescription = "Guardado",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))


        // -------- MENSAJE FINAL --------
        Text(
            text =
                if (username.isNullOrEmpty())
                    "¡Excelente! Ya sabes usar lo básico de Instagram. Ahora puedes navegar, seguir personas y guardar tus publicaciones favoritas. ¡Felicidades!"
                else
                    "¡Muy bien $username! Ya sabes usar lo básico de Instagram: navegar, buscar, dar me gusta y guardar publicaciones. ¡Sigue así!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}