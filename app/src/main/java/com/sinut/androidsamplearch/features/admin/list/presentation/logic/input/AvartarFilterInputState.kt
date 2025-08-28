package com.sinut.androidsamplearch.features.admin.list.presentation.logic.input

import com.sinut.core_data.api.avartar.constants.AvartarPet
import com.sinut.core_data.api.avartar.constants.AvartarStatus

data class AvartarFilterInputState(
    val searchText: String? = null,
    val status: List<AvartarStatus> = emptyList(),
    val pets: List<AvartarPet> = emptyList(),
)