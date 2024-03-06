package com.parstamin.composearamkade.data.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Keep
@Serializable
data class ResponseMediationItem(

	@SerialName("image")
	val image: String? = null,

	@SerialName("sessions")
	val sessions: String? = null,

	@SerialName("titile")
	val titile: String? = null,

	@SerialName("id")
	val id: Int? = null,
	@SerialName("image2")
	val image2: String? = null
)
