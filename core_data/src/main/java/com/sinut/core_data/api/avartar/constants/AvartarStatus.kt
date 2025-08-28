package com.sinut.core_data.api.avartar.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AvartarStatus(val value: String) {
    @SerialName("single")
    SINGLE("single"),

    @SerialName("couple")
    COUPLE("couple"),

    @SerialName("married")
    MARRIED("married");
}