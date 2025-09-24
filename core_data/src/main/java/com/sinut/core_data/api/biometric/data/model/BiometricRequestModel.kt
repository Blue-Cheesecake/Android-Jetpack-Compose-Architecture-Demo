package com.sinut.core_data.api.biometric.data.model

import com.google.gson.annotations.SerializedName

data class BiometricRequestModel(
    @SerializedName("device_id")
    val deviceId: String,

    @SerializedName("public_key")
    val publicKey: String
)