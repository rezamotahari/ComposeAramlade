package com.parstamin.composearamkade.ui.screen.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.parstamin.composearamkade.ui.theme.bac


@Composable
fun BottomAppBar(
    navController: NavController,
    onItemClick: (BottomAppBarItem) -> Unit
) {
    val bottomAppBarItems = listOf(
        BottomAppBarItem.Music,
        BottomAppBarItem.Meditation

    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier.height(50.dp),
        containerColor = bac
    ) {
        bottomAppBarItems.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == item.route
                } == true,
                onClick = {
                    onItemClick(item)
                }
            )
        }
    }
}