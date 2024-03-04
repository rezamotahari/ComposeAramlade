package com.parstamin.composearamkade.data.repository


import android.util.Log
import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import com.parstamin.composearamkade.data.network.ApiServices
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MeditationRepository @Inject constructor(private val apiServices: ApiServices) {

    suspend fun getMeditationCat(): Flow<Response<List<ResponseMeditationCatItem>>> {
        return flow {
            val response = apiServices.getMeditationCat()
            emit(response)
        }.catch { e ->
            Log.e("FoodsListRepository", "Error: ${e.message}")
        }
    }
    suspend fun getMeditationItem(catId: Int) : Flow<Response<List<ResponseMediationItem>>> {
       return flow {
           val response = apiServices.getmeditationitem(catId)
           emit(response)
       }.catch { e ->
           Log.e("FoodsListRepository", "Error: ${e.message}")
       }
   }
}