package com.parstamin.composearamkade.data.network

import com.parstamin.composearamkade.data.model.ResponseMediationItem
import com.parstamin.composearamkade.data.model.ResponseMeditationCatItem
import com.parstamin.composearamkade.utils.BASE_URL
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.contentType

class KtorApiServiceImpl(private val httpClient: HttpClient) : KtorApiService {

    override suspend fun getMeditationItem(cat: Int): List<ResponseMediationItem> =
        httpClient.get("${BASE_URL}/meditation/meditation_item.php") {
            url {
                parameters.append("cat_id", "$cat")
            }
            headers {
                append("Accept", "application/json")
            }
        }.body<List<ResponseMediationItem>>()

    override suspend fun getCatMeditation(): List<ResponseMeditationCatItem> =
        httpClient.get("${BASE_URL}/meditation/meditation_cat.php") {
            headers {
                append("Accept", "application/json")
            }
        }.body<List<ResponseMeditationCatItem>>()

}
