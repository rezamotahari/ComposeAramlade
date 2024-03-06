package com.parstamin.composearamkade.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Keep
@Serializable
data class ResponseMeditationCatItem(
    @SerialName("titile")
    val titile: String? = null,

    @SerialName("id")
    val id: Int? = null,
)
