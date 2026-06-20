package edu.ucne.api_planets.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import edu.ucne.api_planets.presentation.planets.PlanetDetailScreen
import edu.ucne.api_planets.presentation.planets.PlanetsListScreen

@Composable
fun PlanetsNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.PlanetList
    ) {
        composable<Screen.PlanetList> {
            PlanetsListScreen(
                goToPlanet = { id ->
                    navHostController.navigate(Screen.PlanetDetail(id))
                }
            )
        }
        composable<Screen.PlanetDetail> {
            val args = it.toRoute<Screen.PlanetDetail>()
            PlanetDetailScreen(
                planetId = args.planetId,
                onNavigateBack = { navHostController.navigateUp() }
            )
        }
    }
}