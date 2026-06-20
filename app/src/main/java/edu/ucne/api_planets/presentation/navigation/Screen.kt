package edu.ucne.api_planets.presentation.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable data object PlanetList : Screen()
    @Serializable data class PlanetDetail(val planetId: Int) : Screen()
}