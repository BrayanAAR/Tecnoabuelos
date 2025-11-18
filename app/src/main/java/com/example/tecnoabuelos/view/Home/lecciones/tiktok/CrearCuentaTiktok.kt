package com.example.tecnoabuelos.view.Home.lecciones.tiktok

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
fun CrearCuentaTiktok(
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
        Text("Cómo crear una cuenta de Tiktok", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        Text("1. Busca el ícono de tiktok en tu pantalla.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_tiktok0),
            contentDescription = "Icono de Tiktok",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("2. Una vez encontrado, toca el ícono para abrir la aplicación. Se debería ver algo similar a lo siguiente:\n\n", fontSize = 22.sp)
        Text("-Aqui mismo presiona el logo del perfil para dar inicio a la creracion de la cuenta\n\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_tiktok5),
            contentDescription = "Primera vista Tikttok abierto",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text("3. Una vez abierto la seccion del perfil al no tener cuenta nos pedira ingresar una o crear." +
                "Por esto mismo, presionaremos en registrarse que se encuetra en la parte de abajo.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok6),
            contentDescription = "registrarse toktok",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text("4. En este caso nos registraremos con el numero de telefono, pero puedes elegir la opcion que te acomode, los pasos seria iguales.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok7),
            contentDescription = "ingresar numero",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text("le damos a continuar como se muestra en la imagen siguiente.\n", fontSize = 22.sp)

        Image(
            painter = painterResource(id = R.drawable.ic_tiktok8),
            contentDescription = "continuar con el numero",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text("Ingresa el numero de verificacion, si usaste el numero de telefono este se ingresara automaticamente," +
                "luego le das a 'Crear cuenta'.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok9),
            contentDescription = "ingresar numero de verificacion",
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
            painter = painterResource(id = R.drawable.ic_tiktok10),
            contentDescription = "Ingresar fecha de nacimiento",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "6. Te pedira que ingreses una contraseña que contenga numero y un caracter especial, puedes cambiarlo mas adelante.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok11),
            contentDescription = "Ingresar clave",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text("7. Ingresa el usuario con el cual los demas te reconoceran.\n", fontSize = 22.sp)
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok12),
            contentDescription = "ingresar apodo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))


        Text(
            "8.Con eso terminamos de crear la cuenta y puedes revisar tu perfil en el icono de la esquina inferior derecha.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok5),
            contentDescription = "Fin ccreacion de perfil",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_tiktok13),
            contentDescription = "Fin ccreacion de perfil",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = if (username.isNullOrEmpty())
                "¡Felicitaciones por crear tu nueva cuenta de Tiktok!"
            else
                "¡Felicitaciones $username, por crear tu nueva cuenta de Tiktok!",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}
