package com.example.tecnoabuelos.view.Home.lecciones.alarma

import androidx.compose.foundation.layout.*
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
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.core.navigation.Screens


@Composable
fun Alarma(
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
        Spacer(modifier = Modifier.height(30.dp))
        Text("¿Qué quieres aprender hoy sobre Alarma?", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.ProgramarAlarma.route) }) {
            Text("Como programar una alarma", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.EliminarAlarma.route) }) {
            Text("Como eliminar una alarma", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}
