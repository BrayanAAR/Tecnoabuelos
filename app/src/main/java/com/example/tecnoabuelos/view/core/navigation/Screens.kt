package com.example.tecnoabuelos.view.core.navigation
import kotlinx.serialization.Serializable
sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object RedesSociales : Screens("RedesSociales")
    object AplicacionesSistema : Screens("AplicacionesSistema")


    //Redes Sociales
    //Wsp
    object Whatsapp : Screens("Whatsapp")
    object FotoPerfil : Screens("FotoPerfil")
    object AgregarContacto : Screens("AgregarContacto")
    object EnviarContacto : Screens("EnviarContacto")
    object CambiarTamaño : Screens("CambiarTamaño")

    //Facebook
    object Facebook : Screens("Facebook")

    //Instagram
    object Instagram : Screens("Instagram")

    //Tiktok
    object Tiktok : Screens("Tiktok")

    //Internet
    object Interner : Screens("Interner")



    //Aplicaciones del sistema
    //Galeria
    object Galeria : Screens("Galeria")

    //Alarma
    object Alarma : Screens("Alarma")
    object ProgramarAlarma : Screens("ProgramarAlarma")
    object EliminarAlarma : Screens("EliminarAlarma")

    //object Buscador : Screens("Buscador")

    //Contacto
    object Contactos : Screens("Contactos")

    //Camara
    object Camara : Screens("Camara")

    //sonidos
    object Sonido : Screens("Sonido")

    //Notificaciones
    object Notificaciones : Screens("Notificaciones")

}
