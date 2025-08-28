package com.sinut.core_data.api.avartar.constants

import com.sinut.core_data.common.interfaces.CommonLabelItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AvartarStatus(val value: String, override val label: String): CommonLabelItem {
    @SerialName("single")
    SINGLE("single", "Single"),

    @SerialName("couple")
    COUPLE("couple", "Couple"),

    @SerialName("married")
    MARRIED("married", "Married");
}