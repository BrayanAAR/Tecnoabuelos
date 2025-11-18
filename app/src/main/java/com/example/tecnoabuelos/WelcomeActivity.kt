package com.example.tecnoabuelos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.tecnoabuelos.data.datastore.PreferencesRepository
import com.example.tecnoabuelos.databinding.ActivityWelcomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var repo: PreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        repo = PreferencesRepository(this)

        lifecycleScope.launch {
            val username = repo.usernameFlow.first()
            if (!username.isNullOrEmpty()) {
                irAlHome()
                return@launch
            }
            setupUI()
        }
    }

    private fun setupUI() {
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogo.animate()
            .alpha(1f)
            .setDuration(1500)
            .withEndAction {
                binding.layoutFormulario.alpha = 0f
                binding.layoutFormulario.isVisible = true
                binding.layoutFormulario.animate().alpha(1f).setDuration(500).start()
            }

        binding.btnSiguiente.setOnClickListener {
            procesarDatos()
        }
    }

    private fun procesarDatos() {
        binding.layoutFormulario.animate()
            .alpha(0f)
            .setDuration(300)
            .withEndAction {
                binding.layoutFormulario.isVisible = false
                // Eliminamos la pantalla de "cargando" y vamos directo al mensaje final
                mostrarBienvenidaFinal()
            }
    }

    private fun mostrarBienvenidaFinal() {
        // Ya no es necesario ocultar estos elementos porque no se muestran
        // binding.progressBar.isVisible = false
        // binding.tvCargando.isVisible = false

        val nombre = binding.etNombre.text.toString().trim()
        val mensaje = if (nombre.isEmpty()) "¡Bienvenido!" else "¡Bienvenido, $nombre!"

        binding.tvBienvenidaFinal.text = mensaje
        binding.tvBienvenidaFinal.isVisible = true

        binding.tvBienvenidaFinal.alpha = 0f
        binding.tvBienvenidaFinal.scaleX = 0.5f
        binding.tvBienvenidaFinal.scaleY = 0.5f

        binding.tvBienvenidaFinal.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f)
            .setDuration(1000)
            .withEndAction {
                // Guardar y redirigir usando el repositorio y corrutinas
                lifecycleScope.launch {
                    if (nombre.isNotEmpty()) {
                        repo.setUsername(nombre)
                    }
                    delay(2000) // Esperar 2 segundos para que se lea el mensaje
                    irAlHome()
                }
            }
    }

    private fun irAlHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
