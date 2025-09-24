package com.sinut.core_data.api.biometric.data.model

import com.google.gson.annotations.SerializedName

data class BiometricChallengeRequestModel(
    @SerializedName("device_id")
    val deviceId: String
)