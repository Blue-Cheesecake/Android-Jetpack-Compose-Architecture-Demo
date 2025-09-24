package com.sinut.core_data.api.biometric.data.model

import com.google.gson.annotations.SerializedName

data class BiometricResponseModel(
    @SerializedName("status")
    val status: Int,
    @SerializedName("code")
    val code: String,
    @SerializedName("message_key")
    val messageKey: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("reference_id")
    val referenceId: String
)

data class BioMetricResponseWithResultModel(
    @SerializedName("status")
    val status: Int,
    @SerializedName("code")
    val code: String,
    @SerializedName("message_key")
    val messageKey: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("reference_id")
    val referenceId: String,
    @SerializedName("result")
    val result: BiometricSuccessResult,
)

data class BiometricSuccessResult(
    @SerializedName("biometric_id")
    val biometricId: String
)