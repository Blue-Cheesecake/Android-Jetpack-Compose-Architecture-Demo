package com.sinut.androidsamplearch.features.admin.list.presentation.logic.input

import com.sinut.core_data.api.avartar.constants.AvartarPet
import com.sinut.core_data.api.avartar.constants.AvartarStatus

data class AvartarFilterInputState(
    val searchText: String? = null,
    val tempStatus: List<AvartarStatus> = emptyList(),
    val status: List<AvartarStatus> = emptyList(),
    val tempPets: List<AvartarPet> = emptyList(),
    val pets: List<AvartarPet> = emptyList(),
)