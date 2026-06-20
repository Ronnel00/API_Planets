package edu.ucne.api_planets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import edu.ucne.api_planets.presentation.navigation.PlanetsNavHost
import edu.ucne.api_planets.ui.theme.API_PlanetsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            API_PlanetsTheme {
                val navController = rememberNavController()
                PlanetsNavHost(navHostController = navController)
            }
        }
    }
}