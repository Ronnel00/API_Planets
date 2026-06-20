package edu.ucne.api_planets.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlanetDto(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val characters: List<CharacterDto> = emptyList()
)

@JsonClass(generateAdapter = true)
data class CharacterDto(
    val id: Int,
    val name: String,
    val race: String? = null,
    val image: String? = null
)

@JsonClass(generateAdapter = true)
data class PlanetsResponse(
    val items: List<PlanetDto>,
    val meta: MetaDto
)

@JsonClass(generateAdapter = true)
data class MetaDto(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)