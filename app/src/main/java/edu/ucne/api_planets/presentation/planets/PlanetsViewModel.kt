package edu.ucne.api_planets.presentation.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.api_planets.domain.usecase.GetPlanetsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val getPlanets: GetPlanetsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PlanetsUiState(isLoading = true))
    val state: StateFlow<PlanetsUiState> = _state.asStateFlow()

    init { load() }

    fun load() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val planets = getPlanets()
                _state.update { it.copy(isLoading = false, planets = planets) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun onFiltroChanged(valor: String) {
        _state.update { it.copy(filtro = valor) }
    }
}