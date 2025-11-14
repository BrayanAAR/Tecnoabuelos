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

@Composable
fun FotoPerfil(
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
        Spacer(modifier = Modifier.height(50.dp))
        Text("Cómo cambiar la foto de perfil", fontSize = 26.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el siguiente ícono WhatsApp en tu pantalla.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp0),
            contentDescription = "Icono de whatsapp",
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
            painter = painterResource(id = R.drawable.ic_whatsapp1),
            contentDescription = "Whatsapp abierta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("3. Busca los tres puntitos de la parte superior. Al presionarlos debera aparecer un menu como este:\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp2),
            contentDescription = "Menu desplegado tres puntitos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. Selecciona la opcion que dice ajustes\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp2),
            contentDescription = "Menu desplegado tres puntitos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("5. Presiona sobre la foto de perfil\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp4),
            contentDescription = "foto en rojo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("6. Presionar 'Editar' que se encuentra debajo de la foto \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp5),
            contentDescription = "Editar debajo de la foto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("7. Existen dos opciones para elejir una nueva foto. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp11),
            contentDescription = "Opciones cambio",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Text("Primera opcion, buscamos una foto existente por la galeria  \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp6),
            contentDescription = "Fotos de la galeria",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("Buscamos la foto deseada y la seleccionamos. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp7),
            contentDescription = "Fotos de la galeria",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("Segunda opcion, tomamos una foto con la camara.  \n", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp10),
            contentDescription = "Opcion de camara",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text("Tomamos una foto con la camara. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp12),
            contentDescription = "Fotos de la galeria",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))


        Text("8. Cualquiera de los opciones, ajustamos la foto en el espacio marcado. \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp8),
            contentDescription = "Ajuste de la foto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("9. Si se ha echo todo correcto debera aparecer un mensaje de 'Se ha actualizado " +
                "la foto de perfil' y se visualizara la nueva foto.  \n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_whatsapp9),
            contentDescription = "Fotos de la galeria",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por cambiar tu foto de perfil!"
            else
                "¡Felicitaciones $username, por cambiar tu foto de perfil!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
