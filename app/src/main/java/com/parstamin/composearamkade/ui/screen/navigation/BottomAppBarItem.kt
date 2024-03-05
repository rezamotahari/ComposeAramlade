package com.parstamin.composearamkade.ui.screen.navigation

import com.parstamin.composearamkade.R


sealed class BottomAppBarItem(val icon: Int, val route: String) {
    data object Meditation: BottomAppBarItem(
        icon = R.drawable.meditationicon,
        route = "HomeScreen"
    )
    data object Music: BottomAppBarItem(
        icon = R.drawable.music,
        route = "Music"
    )
}