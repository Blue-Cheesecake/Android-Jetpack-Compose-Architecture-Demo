package com.sinut.core_data.api.avartar.constants

import com.sinut.core_data.common.interfaces.CommonLabelItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AvartarPet(val value: String, override val label: String) : CommonLabelItem {
    @SerialName("cat")
    CAT("cat", "Cat"),
    @SerialName("deer")
    DEER("deer", "Deer"),
    @SerialName("dog")
    DOG("dog", "Dog"),
    @SerialName("fish")
    FISH("fish", "Fish");
}