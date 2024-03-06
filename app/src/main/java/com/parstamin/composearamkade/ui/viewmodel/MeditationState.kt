package com.parstamin.composearamkade.ui.viewmodel

import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem

data class MeditationState(

    val allCat: List<ResponseMeditationCatItem> = listOf(),
    val allMeditation: List<ResponseMediationItem> = listOf(),
    val isLoading: Boolean = false,
    val message: String? = null
)


