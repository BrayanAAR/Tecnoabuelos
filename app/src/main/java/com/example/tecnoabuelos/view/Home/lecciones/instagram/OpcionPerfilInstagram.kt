package com.example.tecnoabuelos.view.Home.lecciones.instagram

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
fun OpcionPerfilInstagram(
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
        Text("Opciones del Perfil de Instagram", style=headlineSmallStyle)
        Spacer(modifier = Modifier.height(20.dp))

        // --- INICIO DE CONTENIDO ---

        Text(
            "1. Para abrir tu perfil, toca el ícono con tu foto en la esquina inferior derecha.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram14),
            contentDescription = "Botón para ir al perfil",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "2. Aquí podrás ver tu foto de perfil, tu nombre, tu biografía y tus publicaciones.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram15),
            contentDescription = "Vista del perfil",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "3. Si tocas 'Editar perfil', podrás cambiar:\n" +
                    "- Tu foto de perfil.\n" +
                    "- Tu nombre.\n" +
                    "- Tu usuario (@usuario).\n" +
                    "- Tu biografía.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram16),
            contentDescription = "Editar perfil",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "4. Foto de perfil: Puedes elegir una que tengas en tu galería o tomarte una nueva.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram17),
            contentDescription = "Cambiar foto de perfil",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "5. Biografía: Puedes escribir unas palabras sobre ti. Por ejemplo:\n" +
                    "\"Amante de la vida y la familia\".\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram18),
            contentDescription = "Editar biografía",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "6. Publicaciones: Aquí podrás ver todas las fotos y videos que tú has subido.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram19),
            contentDescription = "Publicaciones del perfil",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "7. Seguidores y seguidos:\n" +
                    "- Seguidores: personas que ven tus publicaciones.\n" +
                    "- Siguiendo: personas que tú sigues.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram20),
            contentDescription = "Seguidores y seguidos",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "8. Configuración del perfil: tocando las tres líneas arriba a la derecha, podrás:\n" +
                    "- Acceder a Ajustes.\n" +
                    "- Revisar tu actividad.\n" +
                    "- Ver tus archivos y guardados.\n" +
                    "- Configurar privacidad y seguridad.\n",
            fontSize = 22.sp
        )
        Image(
            painter = painterResource(id = R.drawable.ic_instagram21),
            contentDescription = "Botón de ajustes",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_instagram13),
            contentDescription = "Botón de ajustes",
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = if (username.isNullOrEmpty())
                "¡Ya conoces todas las opciones del perfil de Instagram!"
            else
                "¡Muy bien $username! Ya conoces todas las opciones del perfil de Instagram.",
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // --- BOTÓN VOLVER ---
        Button(onClick = { navController.popBackStack() }) {
            Text("← Volver al menú", fontSize = 20.sp)
        }
    }
}