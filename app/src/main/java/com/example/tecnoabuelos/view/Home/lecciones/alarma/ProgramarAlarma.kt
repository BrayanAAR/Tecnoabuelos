package com.example.tecnoabuelos.view.Home.lecciones.alarma

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.tecnoabuelos.R
import com.example.tecnoabuelos.view.Home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgrmarAlarma(
    navController: NavHostController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val username = homeViewModel.username.collectAsState().value
    val headlineSmallStyle = MaterialTheme.typography.headlineSmall

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "¿Cómo se programa una alarma?",
                        style = headlineSmallStyle,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver al menú anterior",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "1. Busca el siguiente ícono en tu teléfono, Puede decir Reloj o Alarma.\n",
                fontSize = 22.sp
            )

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

            Text(
                "3. Presiona en la parte superior el '+' para comenzar a agregar una nueva alarma. Se verá algo similar a esto: \n",
                fontSize = 22.sp
            )
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
                "- La primera opción es presionar sobre el número y seleccionar la hora deseada\n",
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
                "- La segunda opción es deslizar el número hacia arriba o abajo hasta tener la hora deseada\n",
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
            Text(
                "5. Una vez seleccionada la hora deseada. Puedes dejarla programada por varios dias\n",
                fontSize = 22.sp
            )
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

            Text(
                "6. Una vez hecho todo lo anterior, ya estás listo para guardar la alarma\n",
                fontSize = 22.sp
            )
            Text(
                "Como en este caso que se guardó una alarma de lunes a viernes a las 11:00 hrs con el nombre de 'Ayuda Tecnológica'  \n",
                fontSize = 22.sp
            )
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
                    "¡Felicitaciones $username por finalizar y agregar una nueva Alarma!",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("← Volver al menú", fontSize = 20.sp)
            }
        }
    }
}
