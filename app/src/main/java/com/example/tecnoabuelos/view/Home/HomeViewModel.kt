package com.example.tecnoabuelos.view.Home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoabuelos.data.datastore.PreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = PreferencesRepository(application)

    val temaOscuro = repo.temaOscuroFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = false
    )

    val username = repo.usernameFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ""
    )

    fun setTemaOscuro(enabled: Boolean) {
        viewModelScope.launch { repo.setTemaOscuro(enabled) }
    }

    fun setUsername(nombre: String) {
        viewModelScope.launch { repo.setUsername(nombre) }
    }
}
