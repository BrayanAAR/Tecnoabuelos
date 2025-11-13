package com.example.tecnoabuelos.view.Home.lecciones.alarma

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
fun EliminarAlarma(
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
        Text("Como eliminar una la Alarma", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el siguiente ícono en tu pantalla, Puede decir Reloj o Alarma.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_reloj1),
            contentDescription = "Icono de reloj",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n",
            fontSize = 22.sp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_reloj2),
            contentDescription = "Reloj abierta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("3. Manten presionado sobre la alrma que deseas eliminar. Se vera algo similar a esto: \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj9),
            contentDescription = "Una alarma seleccionada",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "4. En este paso puedes selecionar mas alarmas que deseas eliminar\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_reloj10),
            contentDescription = "Mas de una alarma seleccionada",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("5. Una vez seleccionada la(s) Alarama(s) deseada.Puedes presionar eliminar en la parte inferior de la pantalla\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj11),
            contentDescription = "Boton de eliminar alarma",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Y ya se habran eliminado las alarmas \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj12),
            contentDescription = "aplicacion sin dos alarmas",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por finalizar y elimar una Alarma!"
            else
                "¡Felicitaciones $username, por finalizar y eliminar una Alarma!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}

