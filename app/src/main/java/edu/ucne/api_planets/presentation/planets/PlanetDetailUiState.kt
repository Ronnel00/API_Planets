package edu.ucne.api_planets.presentation.planets

import edu.ucne.api_planets.domain.model.Planet

data class PlanetDetailUiState(
    val isLoading: Boolean = false,
    val planet: Planet? = null,
    val error: String? = null
)