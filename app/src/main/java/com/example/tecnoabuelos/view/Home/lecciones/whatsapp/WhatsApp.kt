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
import com.example.tecnoabuelos.view.core.navigation.Screens


@Composable
fun Whatsapp(navController: NavHostController,homeViewModel: HomeViewModel = viewModel()
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
        Text("Whatsapp", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.FotoPerfil.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como cambiar la foto de perfil", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.AgregarContacto.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como agregar un contacto", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.EnviarContacto.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como enviar un contacto", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.CambiarTamaño.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como cambiar el tamaño de la letra", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))


        Button(onClick = { navController.popBackStack() },modifier = Modifier.width(300.dp)
        ) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}
