package com.example.tecnoabuelos.view.Home.lecciones.whatsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
fun EnviarContacto(
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
                        "¿Cómo se envia un contacto?",
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

            Text("1. Busca el siguiente ícono de WhatsApp en tu teléfono.\n", fontSize = 22.sp)

            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp0),
                contentDescription = "Icono de whatsapp",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n\n",
                fontSize = 22.sp
            )

            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp1),
                contentDescription = "Whatsapp abierta",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
            Text("3. Busca y selecciona el chat en el que quieras enviar el contacto.\n", fontSize = 22.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp13),
                contentDescription = "Chat abierto",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "4. Presiona el clip de la parte inferior, como se muestra en la siguiente imagen.\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp17),
                contentDescription = "'clip de whatsapp",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "5. En el menú que se despliega selecciona la opción de 'Contacto'\n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp18),
                contentDescription = "sellecionar contacto",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "6. Buscamos el contacto que queremos enviar (Nota: Podemos seleccionar más de 1). \n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp19),
                contentDescription = "Seleccionando los contactos para enviar ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "7. Presionamos 'Enviar' y aparecerá el contacto en el chat de la otra persona  \n",
                fontSize = 22.sp
            )
            Image(
                painter = painterResource(id = R.drawable.ic_whatsapp20),
                contentDescription = "Chat con el contacto enviado",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))


            Text(
                text = if (username.isNullOrEmpty())
                    "¡Felicitaciones por enviar ese contacto!"
                else
                    "¡Felicitaciones $username por enviar ese contacto!",
                fontSize = 22.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("← Volver al menú", fontSize = 20.sp)
            }
        }
    }
}