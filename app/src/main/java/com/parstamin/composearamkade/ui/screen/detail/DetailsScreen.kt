package com.parstamin.composearamkade.ui.screen.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailsScreen(navController: NavController, image: String, image2: String) {
    GlideImage(
        model = image2,
        contentDescription = "",
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(400.dp),
        contentScale = ContentScale.Fit

    )

}