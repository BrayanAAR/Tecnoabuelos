package com.example.tecnoabuelos.view.Home.lecciones.facebook

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
fun CrearCuentaFacebook(
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
        Text("Cómo crear una cuenta de Facebook", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el ícono de Facebook en tu pantalla.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_facebook0),
            contentDescription = "Icono de Facebook",
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
            painter = painterResource(id = R.drawable.ic_facebook1),
            contentDescription = "Primera vista instagram abierto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("3. Presion en 'Crear cuenta nueva' la parte inferior.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_facebook2),
            contentDescription = "Escribiendo en el buscdor de la playstore",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. Presionamos sobre el boton azul para comenzar.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_facebook3),
            contentDescription = "Comenzr de facebook",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("Si te pide permisos para acceder a tus contactos, es para que sea mas facil encontrar despues a tus conocidos.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_facebook4),
            contentDescription = "solicitud de permisos para contactos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "5. Te pedira que ingreses tu fecha de nacimiento para corroborar que eres mayor de edad" +
                    ", aun que la juventud es eterna!.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook5),
            contentDescription = "Ingresar fecha de nacimiento",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "6. Te pedira elegir tu genero, ingresa la opcion que mas te acomode, puedes cambiarlo mas adelante.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook6),
            contentDescription = "Ingresar genero",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text("7. Puedes crear tu cuenta usando tu número de teléfono o tu correo. En este caso la haremos con el telefono, pero los pasos son prácticamente los mismos, así que no te preocupes.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_facebook7),
            contentDescription = "opcion para crear cuenta",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            "8. Una vez ingresado el telefono o correo, deberás crear una contraseña para tu nueva cuenta\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook8),
            contentDescription = "Crear contraseña",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "9. Acepta las condiciones y politicas de Facebook.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook9),
            contentDescription = "Aceptar condiciones y politicas",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "10. Agrega una foto desde la galeria o una que te tomes en el momento, esta foto sera" +
                    " visible para los demas usuarios, No te preocupes, despues se puede cambiar.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook10),
            contentDescription = "Elegir foto de perfil",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            " De ser necesario dale los permisos para poder acceder a tus fotos de la galeria\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook11),
            contentDescription = "permisos Elegir foto de perfil",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            "11.Con eso terminamos de crear la cuenta y ya puedes usar Facebook.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_facebook12),
            contentDescription = "Fin ccreacion de perfil",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por crear tu nueva cuenta de Facebook!"
            else
                "¡Felicitaciones $username, por crear tu nueva cuenta de Facebook!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
