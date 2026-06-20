package edu.ucne.api_planets.domain.usecase

import edu.ucne.api_planets.domain.repository.PlanetsRepository
import javax.inject.Inject

class GetPlanetByIdUseCase @Inject constructor(
    private val repository: PlanetsRepository
) {
    suspend operator fun invoke(id: Int) = repository.getPlanetById(id)
}