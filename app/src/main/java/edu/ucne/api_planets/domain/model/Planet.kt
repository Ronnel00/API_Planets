package edu.ucne.api_planets.domain.model

data class Planet(
    val id: Int,
    val name: String,
    val isDestroyed: Boolean,
    val description: String,
    val image: String,
    val characters: List<Character> = emptyList()
)

data class Character(
    val id: Int,
    val name: String,
    val race: String? = null,
    val image: String? = null
)