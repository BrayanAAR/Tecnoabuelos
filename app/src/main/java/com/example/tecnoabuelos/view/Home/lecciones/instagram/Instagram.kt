package com.example.tecnoabuelos.view.Home.lecciones.instagram

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.view.core.navigation.Screens

@Composable
fun Instagram(navController: NavHostController,homeViewModel: HomeViewModel = viewModel()
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
        Text("Instagram", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.DescargarInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como descargar Instagram", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.CrearCuentaInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como crear tu cuenta de Instagram", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.OpcionPerfilInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Opciones del perfil", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.MensajesInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como visualizar y responder mensajes de instagram ", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.HistoriasInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como subir historias en Instagram", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.BuscadorInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como buscar cuentas, dar me gustas, comentar, compartir o guardar una publicacion en Instagram", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.PublicarInstagram.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como publicar una foto o video en Instagram", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))


        Button(onClick = { navController.popBackStack() },modifier = Modifier.width(300.dp)
        ) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}
