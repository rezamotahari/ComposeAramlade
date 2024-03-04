package com.parstamin.composearamkade.data.model

import com.google.gson.annotations.SerializedName

data class ResponseMeditationCatItem(
    @field:SerializedName("titile")
    val titile: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,
)
