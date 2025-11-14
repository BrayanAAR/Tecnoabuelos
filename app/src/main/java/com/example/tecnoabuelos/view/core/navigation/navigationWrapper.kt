package com.example.tecnoabuelos.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tecnoabuelos.view.Home.HomeScreens
import com.example.tecnoabuelos.view.Home.lecciones.galeria.Galeria
import com.example.tecnoabuelos.view.Home.lecciones.alarma.Alarma
import com.example.tecnoabuelos.view.Home.lecciones.alarma.EliminarAlarma
import com.example.tecnoabuelos.view.Home.lecciones.alarma.ProgrmarAlarma
import com.example.tecnoabuelos.view.Home.lecciones.redesSociales.RedesSociales
import com.example.tecnoabuelos.view.Home.lecciones.aplicacionesSistema.AplicacionesSistema
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.Whatsapp
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.FotoPerfil
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.AgregarContacto
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.EnviarContacto
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.CambiarTamaño
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.DescargaWhatsapp
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.RealizarLlamada



//import com.example.tecnoabuelos.view.Home.lecciones.buscador.Buscador
//import com.example.tecnoabuelos.view.Home.lecciones.intagram.Instagram
//import com.example.tecnoabuelos.view.Home.lecciones.facebook.Facebook
//import com.example.tecnoabuelos.view.Home.lecciones.contactos.Contactos
//import com.example.tecnoabuelos.view.Home.lecciones.camara.Camara
//import com.example.tecnoabuelos.view.Home.lecciones.sonido.Sonido
//import com.example.tecnoabuelos.view.Home.lecciones.notificaciones.Notificaciones
//import com.example.tecnoabuelos.view.Home.lecciones.internet.Interner

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        // ********************** Pantalla de inicio **********************
        composable(Screens.Home.route) {
            HomeScreens(navController)
        }
        composable(Screens.RedesSociales.route) {
            RedesSociales(navController)
        }
        composable(Screens.AplicacionesSistema.route) {
            AplicacionesSistema(navController)
        }

        //********************** Redes Sociales **********************
        //Wsp
        composable(Screens.Whatsapp.route) {
            Whatsapp(navController)
        }
        composable(Screens.DescargaWhatsapp.route){
            DescargaWhatsapp(navController)
        }
        composable(Screens.FotoPerfil.route) {
            FotoPerfil(navController)
        }
        composable(Screens.AgregarContacto.route) {
            AgregarContacto(navController)
        }
        composable(Screens.EnviarContacto.route) {
            EnviarContacto(navController)
        }
        composable(Screens.CambiarTamaño.route) {
            CambiarTamaño(navController)
        }
        composable(Screens.RealizarLlamada.route) {
            RealizarLlamada(navController)
        }

        //Facebook
        composable(Screens.Facebook.route) {
            //Facebook(navController)
        }

        //Instagram
        composable(Screens.Instagram.route) {
            //Instagram(navController)
        }

        //Tiktok
        composable(Screens.Tiktok.route) {
            //Tiktok(navController)
        }

        //Internet
        composable(Screens.Interner.route) {
            //Interner(navController)
        }



        //********************** Aplicaciones del sistema **********************
        //Galeria
        composable(Screens.Galeria.route) {
            Galeria(navController)
        }

        //Alarma
        composable(Screens.Alarma.route) {
            Alarma(navController)
        }
        composable(Screens.ProgramarAlarma.route) {
            ProgrmarAlarma(navController)
        }
        composable(Screens.EliminarAlarma.route) {
            EliminarAlarma(navController)
        }

        //Buscador
        //composable(Screens.Buscador.route) {
            //Buscador(navController)
        //}

        //Contacto
        composable(Screens.Contactos.route) {
            //Contactos(navController)
        }

        //Camara
        composable(Screens.Camara.route) {
            //Camara(navController)
        }

        //sonidos
        composable(Screens.Sonido.route) {
            //Sonido(navController)
        }

        //Notificaciones
        composable(Screens.Notificaciones.route) {
            //Notificaciones(navController)
        }
    }
}
