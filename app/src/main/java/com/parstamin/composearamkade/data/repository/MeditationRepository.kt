package com.parstamin.composearamkade.data.repository


import android.util.Log
import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import com.parstamin.composearamkade.data.network.KtorApiServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow


class MeditationRepository(
    private val apiServices: KtorApiServiceImpl
) {

    suspend fun getMeditationCat(): Flow<List<ResponseMeditationCatItem>> {
        return flow {
            val response = apiServices.getCatMeditation()
            emit(response)
        }.catch { e ->
            Log.e("MeditationRepository", "Error: ${e.message}")
        }
    }

    suspend fun getMeditationItem(catId: Int): Flow<List<ResponseMediationItem>> =
        flow {
            val response = apiServices.getMeditationItem(catId)
            emit(response)
        }.catch { e ->
            Log.e("MeditationRepository", "Error: ${e.message}")
        }
}