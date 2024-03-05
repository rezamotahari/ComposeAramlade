package com.parstamin.composearamkade.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.parstamin.composearamkade.ui.screen.Bottom_navigation
import com.parstamin.composearamkade.ui.screen.MeditationCat
import com.parstamin.composearamkade.ui.screen.meditationItem


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold() {
                Column(modifier = Modifier.padding(10.dp)) {
                    MeditationCat()
                    Spacer(modifier = Modifier.height(20.dp))
                    meditationItem()

                }
                Bottom_navigation()
            }


        }
    }
}

