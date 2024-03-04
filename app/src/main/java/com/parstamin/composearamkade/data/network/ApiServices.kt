package com.parstamin.composearamkade.data.network


import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {
    @GET("meditation/meditation_cat.php")
    suspend fun getMeditationCat(): Response<List<ResponseMeditationCatItem>>

    @GET("meditation/meditation_item.php")
    suspend fun getmeditationitem(@Query("cat_id") catid: Int): Response<List<ResponseMediationItem>>
}
