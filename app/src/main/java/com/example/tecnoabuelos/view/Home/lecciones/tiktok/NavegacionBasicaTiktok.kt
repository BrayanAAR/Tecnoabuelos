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
fun NavegacionBasicaTiktok(
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
        Text("Primera vez en Tiktok", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el ícono de la aplicacion en la pantalla.\n", fontSize = 22.sp)
        //ic_tiktok0
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok0),
            contentDescription = "Icono de inicio",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text("2. Una vez abierto te pedira aceptar los terminos y condiciones, le daremos en 'Aceptar y continuar' .\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok1),
            contentDescription = "Terminos y condiciones",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Text("3. Ahora te preguntara si quieres recibir notificaciones de la aplicacion, tambien le daremos los permisos.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok2),
            contentDescription = "Permiso notificaciones",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text("4. Tiktok quiere saber un poco mas de ti, por eso te pedira que tipo de contnido quieres ver, puedes seleccionar todos los que quieras.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok3),
            contentDescription = "Categorias de poreferencia",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text("5. Y con eso ya estas listo para usar Tiktok y ver todo lo que te guste.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok4),
            contentDescription = "Home de tiktok",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        // -------- MENSAJE FINAL --------
        Text(
            text =
                if (username.isNullOrEmpty())
                    "¡Excelente! Ya navegar por Tiktok.¡Felicidades!"
                else
                    "¡Muy bien $username! Ya navegar por Tiktok.¡Felicidades!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(50.dp))
        Text("Navegacion basica de Tiktok", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("Busca el ícono de la casita en la esquina inferior de la pantalla.\n", fontSize = 22.sp)
        Text("aqui veras las ultimas publicacions sugeridas para ti.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_tiktok14),
            contentDescription = "Icono de inicio",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text("El icono de las dos personas juntas te muestras los videos de amigos o de la gente que sigues .\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok15),
            contentDescription = "icono amigos",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        Text(" El + que se encuentra en la parte del medio, podras crear un video de tiktok, Puedes ser el nuevo influencer .\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_tiktok18),
            contentDescription = "crear tiktok",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok16),
            contentDescription = "crear tiktok",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text("En el icono de los mensajes podras ver tus converzaciones con otros usuarios.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok17),
            contentDescription = "mensajeria de tiktok ",
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))






        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}