package com.sinut.core_data.api.avartar.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AvartarPet(val value: String) {
    @SerialName("cat")
    CAT("cat"),
    @SerialName("deer")
    DEER("deer"),
    @SerialName("dog")
    DOG("dog"),
    @SerialName("fish")
    FISH("fish");
}