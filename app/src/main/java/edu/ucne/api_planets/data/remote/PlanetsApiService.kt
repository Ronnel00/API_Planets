package edu.ucne.api_planets.data.remote

import edu.ucne.api_planets.data.remote.dto.PlanetDto
import edu.ucne.api_planets.data.remote.dto.PlanetsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlanetsApiService {

    @GET("planets")
    suspend fun getPlanets(
        @Query("limit") limit: Int = 20
    ): PlanetsResponse

    @GET("planets/{id}")
    suspend fun getPlanetById(
        @Path("id") id: Int
    ): PlanetDto
}