package com.example.tecnoabuelos.view.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tecnoabuelos.view.Home.HomeScreens

import com.example.tecnoabuelos.view.Home.lecciones.aplicacionesSistema.AplicacionesSistema
import com.example.tecnoabuelos.view.Home.lecciones.galeria.Galeria
import com.example.tecnoabuelos.view.Home.lecciones.alarma.Alarma
import com.example.tecnoabuelos.view.Home.lecciones.alarma.EliminarAlarma
import com.example.tecnoabuelos.view.Home.lecciones.alarma.ProgrmarAlarma
import com.example.tecnoabuelos.view.Home.lecciones.telefono.Telefono
import com.example.tecnoabuelos.view.Home.lecciones.telefono.NavegacionTelefono



import com.example.tecnoabuelos.view.Home.lecciones.redesSociales.RedesSociales
//wsp
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.Whatsapp
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.FotoPerfil
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.AgregarContacto
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.EnviarContacto
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.CambiarTamaño
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.DescargaWhatsapp
import com.example.tecnoabuelos.view.Home.lecciones.whatsapp.RealizarLlamada
//insta
import com.example.tecnoabuelos.view.Home.lecciones.instagram.Instagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.DescargarInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.OpcionPerfilInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.MensajesInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.HistoriasInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.BuscadorInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.PublicarInstagram
import com.example.tecnoabuelos.view.Home.lecciones.instagram.CrearCuentaInstagram
//face
import com.example.tecnoabuelos.view.Home.lecciones.facebook.Facebook
import com.example.tecnoabuelos.view.Home.lecciones.facebook.DescargarFacebook
import com.example.tecnoabuelos.view.Home.lecciones.facebook.CrearCuentaFacebook
import com.example.tecnoabuelos.view.Home.lecciones.facebook.NavegacionBasicaFacebook
//tiktok
import com.example.tecnoabuelos.view.Home.lecciones.tiktok.Tiktok
import com.example.tecnoabuelos.view.Home.lecciones.tiktok.DescargarTiktok
import com.example.tecnoabuelos.view.Home.lecciones.tiktok.CrearCuentaTiktok
import com.example.tecnoabuelos.view.Home.lecciones.tiktok.NavegacionBasicaTiktok


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
            Facebook(navController)
        }
        composable(Screens.DescargarFacebook.route) {
            DescargarFacebook(navController)
        }
        composable(Screens.CrearCuentaFacebook.route) {
            CrearCuentaFacebook(navController)
        }
        composable(Screens.NavegacionBasicaFacebook.route) {
            NavegacionBasicaFacebook(navController)
        }

        //Instagram
        composable(Screens.Instagram.route) {
            Instagram(navController)
        }
        composable(Screens.DescargarInstagram.route) {
            DescargarInstagram(navController)
        }
        composable(Screens.CrearCuentaInstagram.route) {
            CrearCuentaInstagram(navController)
        }
        composable(Screens.OpcionPerfilInstagram.route) {
            OpcionPerfilInstagram(navController)
        }
        composable(Screens.MensajesInstagram.route) {
            MensajesInstagram(navController)
        }
        composable(Screens.HistoriasInstagram.route) {
            HistoriasInstagram(navController)
        }
        composable(Screens.BuscadorInstagram.route) {
            BuscadorInstagram(navController)
        }
        composable(Screens.PublicarInstagram.route) {
            PublicarInstagram(navController)
        }

        //Tiktok
        composable(Screens.Tiktok.route) {
            Tiktok(navController)
        }
        composable(Screens.DescargarTiktok.route) {
            DescargarTiktok(navController)
        }
        composable(Screens.CrearCuentaTiktok.route) {
            CrearCuentaTiktok(navController)
        }

        composable(Screens.NavegacionBasicaTiktok.route) {
            NavegacionBasicaTiktok(navController)
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

        //Telefono
        composable(Screens.Telefono.route) {
            Telefono(navController)
        }
        composable(Screens.NavegacionTelefono.route) {
            NavegacionTelefono(navController)
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
