package edu.ucne.api_planets.presentation.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.api_planets.domain.usecase.GetPlanetByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    private val getPlanetById: GetPlanetByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(PlanetDetailUiState(isLoading = true))
    val state: StateFlow<PlanetDetailUiState> = _state.asStateFlow()

    fun load(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val planet = getPlanetById(id)
                _state.update { it.copy(isLoading = false, planet = planet) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }
}