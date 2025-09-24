package com.sinut.core_data.core.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CommonErrorResponseModel(
    @SerializedName("status")
    val status: Int,
    @SerializedName("code")
    val code: String,
    @SerializedName("message_key")
    val messageKey: String,
    @SerializedName("message")
    val message: String
)