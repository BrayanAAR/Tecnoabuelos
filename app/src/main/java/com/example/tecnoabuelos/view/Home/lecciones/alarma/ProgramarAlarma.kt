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
fun ProgrmarAlarma(
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
        Text("Como colocar la Alarma", fontSize = 26.sp)
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

        Text("3. Presiona en la parte superior el '+' para comenzar a agrgar una nueva alarma.Se vera algo similar a esto: \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj3),
            contentDescription = "Editar una alarma",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            "4. En este paso es muy importante seleccionar la hora que uno desea que la alarma suene, para eso hay dos opciones:\n",
            fontSize = 22.sp
        )
        Text(
            "- La primera opcion es presionar sobre el numero y seleccionar la hora deseada\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_reloj4),
            contentDescription = "Escribir la nueva hora",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "- La Segunda opcion es deslizar el numero hacia arriba o abajo hasta tener la hora deseada\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_reloj5),
            contentDescription = "Deslizar la nueva hora",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("5. Una vez seleccionada la hora deseada. Puedes dejarla programada por varios dias\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj6),
            contentDescription = "Marcar mas de un dia",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("o incluso puedes agregarle un nombre descriptivo\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj7),
            contentDescription = "Nombrar la alarma",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("6. Una vez echo todo lo anterior, Ya estas listo para guardar la alarma\n", fontSize = 22.sp)
        Text("Como en este caso que se guardo una alarma de lunes a viernes a las 11:00 hrs con el nombre de 'Ayuda Tecnologica'  \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_reloj8),
            contentDescription = "Boton de guardado",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
                text = if (username.isNullOrEmpty())
                    "¡Felicitaciones por finalizar y agregar una nueva Alarma!"
                else
                    "¡Felicitaciones $username, por finalizar y agregar una nueva Alarma!",
        fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
