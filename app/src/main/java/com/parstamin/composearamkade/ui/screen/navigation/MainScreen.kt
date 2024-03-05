package com.parstamin.composearamkade.ui.screen.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {

    val navHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                navController = navHostController,
                onItemClick = { item ->
                    navHostController.navigate(route = item.route) {
                       /* popUpTo(id = navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }*/
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Nav(navHostController)
        }
    }
}