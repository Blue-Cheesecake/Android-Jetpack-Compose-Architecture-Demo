package com.sinut.core_data.api.biometric.data.model

import com.google.gson.annotations.SerializedName

data class BiometricAuthenRequestModel(
    @SerializedName("device_id")
    val deviceId: String,
    @SerializedName("signed_challenge")
    val signedChallenge: String,
)