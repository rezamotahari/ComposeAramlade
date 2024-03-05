package com.parstamin.composearamkade.data.network


import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem

interface KtorApiService {
    suspend fun getMeditationItem(cat: Int): List<ResponseMediationItem>
    suspend fun getCatMeditation():List<ResponseMeditationCatItem>
}