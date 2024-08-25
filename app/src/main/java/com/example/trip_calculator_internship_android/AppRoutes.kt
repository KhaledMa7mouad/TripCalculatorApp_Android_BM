package com.example.trip_calculator_internship_android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

object Routes {
    const val START = "start"
    const val DESTINATION = "destination"
    const val TIME = "time"
    const val OPTIONS = "options"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.START) {
        composable(route = Routes.START) { StartScreen(navController) }
        composable(route=Routes.DESTINATION) { DistanceScreen(navController) }
        composable(
           route= "${Routes.TIME}/{km}",
            arguments = listOf(
                navArgument("km") { type = NavType.FloatType }
            )

        ) {
            val km = it.arguments?.getFloat("km")!!
            TimeScreen(navController, distance =km)
        }
        composable(
            route = "${Routes.OPTIONS}/{km}/{sec}",
            arguments = listOf(
                navArgument("km"){type = NavType.FloatType},
                navArgument("sec"){type = NavType.IntType}
            )
        )
        {
            val km = it.arguments?.getFloat("km")
            val sec = it.arguments?.getInt("sec")
            OptionsScreen(navController,km!!,sec!!)

        }

    }

}
