package com.example.tecnoabuelos.view.Home.lecciones.facebook

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
fun Facebook(navController: NavHostController,homeViewModel: HomeViewModel = viewModel()
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
        Text("Facebook", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.DescargarFacebook.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como descargar Facebook", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.CrearCuentaFacebook.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Como crear tu cuenta de Facebook", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.navigate(Screens.NavegacionBasicaFacebook.route) },modifier = Modifier.width(300.dp)
        ) {
            Text("Cococe mas de Facebook", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(30.dp))





        Button(onClick = { navController.popBackStack() },modifier = Modifier.width(300.dp)
        ) {
            Text("<- Volver al menú", fontSize = 20.sp)
        }
    }
}
