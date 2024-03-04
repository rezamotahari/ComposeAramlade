package com.parstamin.composearamkade.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseMediationItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("sessions")
	val sessions: String? = null,

	@field:SerializedName("titile")
	val titile: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,
	@field:SerializedName("image2")
	val image2: String? = null
)
