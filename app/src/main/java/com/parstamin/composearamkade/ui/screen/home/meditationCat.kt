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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import com.parstamin.composearamkade.ui.theme.itemBac
import com.parstamin.composearamkade.ui.viewmodel.MeditationViewModel
import com.parstamin.composearamkade.utils.MyResponse
import org.koin.androidx.compose.koinViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeditationCat(
    meditationViewModel: MeditationViewModel = koinViewModel()
) {
    var cat by remember { mutableStateOf(emptyList<ResponseMeditationCatItem>()) }
    var catId by remember { mutableIntStateOf(1) }


    meditationViewModel.getMeditationItem(catId)
    LaunchedEffect(key1 = true) {
        meditationViewModel.getMeditationCat()
        meditationViewModel.getMeditationCat.collect { response ->
            when (response.status) {
                MyResponse.Status.LOADING -> {
                }
                MyResponse.Status.SUCCESS -> {
                    cat = response.data!!
                }
                MyResponse.Status.ERROR -> {

                }

            }

        }
    }
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        LazyRow() {

            items(cat) {
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
                            containerColor =  itemBac
                        ),
                        onClick = {
                            catId = it.id

                        }
                    ) {
                        Text(
                            text = it.titile.toString(),
                            Modifier.align(Alignment.CenterHorizontally)
                            , color =if (isSelected) Color.Green else Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))

            }
        }
    }


}

