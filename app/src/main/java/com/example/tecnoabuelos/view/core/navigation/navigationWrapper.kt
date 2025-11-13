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

//import com.example.tecnoabuelos.view.Home.lecciones.buscador.Buscador
//import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.Whatsapp
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
        // Pantalla de inicio (Home)
        composable(Screens.Home.route) {
            HomeScreens(navController)
        }

        // Lecciones
        composable(Screens.Galeria.route) {
            Galeria(navController)
        }
        composable(Screens.Alarma.route) {
            Alarma(navController)
        }
        composable(Screens.ProgramarAlarma.route) {
            ProgrmarAlarma(navController)
        }
        composable(Screens.EliminarAlarma.route) {
            EliminarAlarma(navController)
        }
        composable(Screens.Buscador.route) {
            //Buscador(navController)
        }
        composable(Screens.Whatsapp.route) {
            //Whatsapp(navController)
        }
        composable(Screens.Instagram.route) {
            //Instagram(navController)
        }
        composable(Screens.Facebook.route) {
            //Facebook(navController)
        }
        composable(Screens.Contactos.route) {
            //Contactos(navController)
        }
        composable(Screens.Camara.route) {
            //Camara(navController)
        }
        composable(Screens.Sonido.route) {
            //Sonido(navController)
        }
        composable(Screens.Notificaciones.route) {
            //Notificaciones(navController)
        }
        composable(Screens.Interner.route) {
            //Interner(navController)
        }
    }
}
