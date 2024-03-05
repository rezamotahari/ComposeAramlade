package com.parstamin.composearamkade.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.parstamin.composearamkade.data.model.ResponseMediationItem

import com.parstamin.composearamkade.ui.theme.bacc
import com.parstamin.composearamkade.ui.theme.cardBac
import com.parstamin.composearamkade.ui.viewmodel.MeditationViewModel
import com.parstamin.composearamkade.utils.MyResponse
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun meditationItem(
    meditationViewModel: MeditationViewModel = koinViewModel(),
    navController: NavController
) {
    var item by remember { mutableStateOf(emptyList<ResponseMediationItem>()) }

    LaunchedEffect(key1 = true) {
        meditationViewModel.getMeditationCat()
        meditationViewModel.getMeditation.collect { response ->
            when (response.status) {
                MyResponse.Status.SUCCESS -> {
                    item = response.data ?: emptyList()
                }
                else -> {
                }
            }
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        content = {
            items(item) { meditation ->
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(200.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(bacc)
                        .clickable {
                            navController.navigate("DetailsScreen?image=${meditation.image}&image2=${meditation.image2}")
                        }
                ) {
                    Column {
                        GlideImage(
                            model = meditation.image,
                            contentDescription = "",
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(80.dp),
                            contentScale = ContentScale.Crop
                        )
                        Card(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth()
                                .height(60.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            colors = CardDefaults.cardColors(containerColor = cardBac)
                        ) {
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = meditation.titile.toString(),
                                Modifier.align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "${meditation.sessions} جلسه",
                                Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }
                }
            }
        }
    )
}
