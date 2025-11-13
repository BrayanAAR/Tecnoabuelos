package com.example.tecnoabuelos.view.core.navigation
import kotlinx.serialization.Serializable
sealed class Screens(val route: String) {
    object Home : Screens("Home")
    object Galeria : Screens("Galeria")
    object Alarma : Screens("Alarma")
    object ProgramarAlarma : Screens("ProgramarAlarma")
    object EliminarAlarma : Screens("EliminarAlarma")
    object Buscador : Screens("Buscador")
    object Whatsapp : Screens("Whatsapp")
    object Instagram : Screens("Instagram")
    object Facebook : Screens("Facebook")
    object Contactos : Screens("Contactos")
    object Camara : Screens("Camara")
    object Sonido : Screens("Sonido")
    object Notificaciones : Screens("Notificaciones")
    object Interner : Screens("Interner")
}
