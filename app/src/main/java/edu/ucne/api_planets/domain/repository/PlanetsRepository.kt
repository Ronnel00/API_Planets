package edu.ucne.api_planets.domain.repository

import edu.ucne.api_planets.domain.model.Planet

interface PlanetsRepository {
    suspend fun getPlanets(): List<Planet>
    suspend fun getPlanetById(id: Int): Planet
}