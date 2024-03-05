package com.parstamin.composearamkade.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold() {
        Column(modifier = Modifier.padding(10.dp)) {
            MeditationCat()
            Spacer(modifier = Modifier.height(20.dp))
            meditationItem(navController=navController)

        }
       // Bottom_navigation()
    }
}