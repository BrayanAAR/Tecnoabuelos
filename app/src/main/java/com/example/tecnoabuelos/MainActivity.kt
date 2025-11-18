package com.example.tecnoabuelos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tecnoabuelos.ui.theme.TecnoAbuelosTheme
import com.example.tecnoabuelos.view.Home.HomeViewModel
import com.example.tecnoabuelos.view.core.navigation.NavigationWrapper

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        // --- INICIO DEL CÓDIGO PARA PANTALLA COMPLETA GLOBAL ---
        // Esto oculta las barras en TODA la app y permite que aparezcan al deslizar

        val windowInsetsController = androidx.core.view.WindowCompat.getInsetsController(window, window.decorView)

        // Configura que las barras aparezcan un momento si deslizas el dedo y luego se escondan solas
        windowInsetsController.systemBarsBehavior =
            androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        // Oculta tanto la barra de navegación (abajo) como la de estado (arriba)
        windowInsetsController.hide(androidx.core.view.WindowInsetsCompat.Type.systemBars())

        // --- FIN DEL CÓDIGO ---

        setContent {
            val homeViewModel: HomeViewModel = viewModel()
            val darkTheme = homeViewModel.temaOscuro.collectAsState().value

            TecnoAbuelosTheme(darkTheme = darkTheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationWrapper()
                }
            }
        }
    }
}
