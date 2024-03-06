package com.parstamin.composearamkade.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.parstamin.composearamkade.ui.theme.itemBac
import com.parstamin.composearamkade.ui.viewmodel.MeditationViewModel
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditationCat(
    meditationViewModel: MeditationViewModel = koinViewModel()
) {
    var catId by remember { mutableIntStateOf(1) }
    val uiState by meditationViewModel.getMeditationCat.collectAsState()

    meditationViewModel.getMeditationItem(catId)

    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        LazyRow() {

            items(uiState.allCat) {
                val isSelected = catId == it.id!!
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(20.dp)
                ) {

                    Card(
                        modifier = Modifier
                            .fillMaxSize(),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = if (isSelected) Color.LightGray else itemBac
                        ),
                        onClick = {
                            catId = it.id

                        }
                    ) {
                        Text(
                            text = it.titile.toString(),
                            Modifier.align(Alignment.CenterHorizontally)
                            , color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
            }
        }
    }
}

