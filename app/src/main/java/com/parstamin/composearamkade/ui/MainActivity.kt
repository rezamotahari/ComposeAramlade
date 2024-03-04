package com.parstamin.composearamkade.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.parstamin.composearamkade.ui.screen.MeditationCat
import com.parstamin.composearamkade.ui.screen.meditationItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.padding(10.dp)) {
                MeditationCat()
                Spacer(modifier = Modifier.height(20.dp))
                meditationItem()
            }

        }
    }
}

