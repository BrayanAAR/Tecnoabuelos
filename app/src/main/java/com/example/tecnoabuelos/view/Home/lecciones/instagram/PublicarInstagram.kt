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
fun PublicarInstagram(
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
        Text("Cómo subir una publicación", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "1. En la barra inferior, toca el símbolo ➕ para comenzar a crear tu publicación.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram40),
            contentDescription = "Botón agregar",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "2. Elige si quieres subir una foto o un video desde tu galería.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram41),
            contentDescription = "Galería",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "3. Puedes mover, ajustar o recortar la imagen para que quede como te guste.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram42),
            contentDescription = "Editar",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "4. Elige un filtro si quieres mejorar o cambiar la apariencia de tu foto.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram43),
            contentDescription = "Filtros",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "5. Escribe una pequeña descripción o mensaje para acompañar tu foto.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram44),
            contentDescription = "Descripción",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            "6. Finalmente, toca 'Compartir' para publicar tu foto o video y visualizarla en tu perfil.",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram45),
            contentDescription = "Compartir",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text =
                if (username.isNullOrEmpty())
                    "¡Muy bien! Ya sabes cómo subir tus fotos y videos. ¡Ahora puedes compartir con tus seres queridos!"
                else
                    "¡Excelente trabajo $username! Ya sabes cómo subir fotos y videos. ¡Tus cercanos podrán ver tus momentos favoritos!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}