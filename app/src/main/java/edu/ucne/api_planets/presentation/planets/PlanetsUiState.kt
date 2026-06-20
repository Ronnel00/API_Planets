package edu.ucne.api_planets.presentation.planets

import edu.ucne.api_planets.domain.model.Planet

data class PlanetsUiState(
    val isLoading: Boolean = false,
    val planets: List<Planet> = emptyList(),
    val filtro: String = "",
    val error: String? = null
)