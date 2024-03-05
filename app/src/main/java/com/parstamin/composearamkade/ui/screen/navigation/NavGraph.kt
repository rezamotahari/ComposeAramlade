package com.parstamin.composearamkade.ui.screen.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.parstamin.composearamkade.ui.screen.detail.DetailsScreen
import com.parstamin.composearamkade.ui.screen.home.HomeScreen
import com.parstamin.composearamkade.ui.screen.muisc.Music

@Composable
fun Nav(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable(route = "HomeScreen") {
            HomeScreen(navController)
        }
        composable(route = "DetailsScreen?image={image}&image2={image2}",
            arguments = listOf(
                navArgument(name = "image"){
                    type = NavType.StringType
                    nullable = true
                },
                navArgument(name = "image2"){
                    type = NavType.StringType
                    nullable = true
                }
            )
            ) {
            DetailsScreen(navController = navController
            ,
                image = it.arguments?.getString("image").toString(),
                image2 = it.arguments?.getString("image2").toString()
            )
        }
        composable(route = "Music") {
            Music()
        }
    }
}