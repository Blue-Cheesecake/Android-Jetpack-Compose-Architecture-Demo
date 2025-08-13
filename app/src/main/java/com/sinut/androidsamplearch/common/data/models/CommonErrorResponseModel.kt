package com.sinut.androidsamplearch.common.data.models

import kotlinx.serialization.Serializable

@Serializable
data class CommonErrorResponseModel(
    val status: String,
    val statusCode: String,
    val message: String,
)