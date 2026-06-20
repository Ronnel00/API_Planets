package edu.ucne.api_planets.data.repository

import edu.ucne.api_planets.data.remote.PlanetsApiService
import edu.ucne.api_planets.domain.model.Character
import edu.ucne.api_planets.domain.model.Planet
import edu.ucne.api_planets.domain.repository.PlanetsRepository
import javax.inject.Inject

class PlanetsRepositoryImpl @Inject constructor(
    private val api: PlanetsApiService
) : PlanetsRepository {

    override suspend fun getPlanets(): List<Planet> {
        return api.getPlanets().items.map { dto ->
            Planet(
                id = dto.id,
                name = dto.name,
                isDestroyed = dto.isDestroyed,
                description = dto.description,
                image = dto.image,
                characters = dto.characters.map { c ->
                    Character(
                        id = c.id,
                        name = c.name,
                        race = c.race,
                        image = c.image
                    )
                }
            )
        }
    }

    override suspend fun getPlanetById(id: Int): Planet {
        val dto = api.getPlanetById(id)
        return Planet(
            id = dto.id,
            name = dto.name,
            isDestroyed = dto.isDestroyed,
            description = dto.description,
            image = dto.image,
            characters = dto.characters.map { c ->
                Character(
                    id = c.id,
                    name = c.name,
                    race = c.race,
                    image = c.image
                )
            }
        )
    }
}