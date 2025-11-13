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
        enableEdgeToEdge()

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
