package com.parstamin.composearamkade.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.parstamin.composearamkade.ui.screen.detail.DetailsScreen
import com.parstamin.composearamkade.ui.screen.home.HomeScreen
import com.parstamin.composearamkade.ui.screen.muisc.Music

@Composable
fun Nav(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {
            HomeScreen(navController)
        }
        composable(route = "DetailsScreen") {
            DetailsScreen(navController = navController)
        }
        composable(route = "Music") {
            Music()
        }
    }
}