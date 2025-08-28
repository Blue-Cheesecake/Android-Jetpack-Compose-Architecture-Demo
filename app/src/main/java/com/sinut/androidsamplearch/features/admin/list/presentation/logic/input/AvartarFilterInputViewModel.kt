package com.sinut.androidsamplearch.features.admin.list.presentation.logic.input

import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.core_data.api.avartar.constants.AvartarPet
import com.sinut.core_data.api.avartar.constants.AvartarStatus
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel

class AvartarFilterInputViewModel : BaseViewModel<AvartarFilterInputState>(AvartarFilterInputState()) {

    fun updateSearchText(value: String?) = setState(uiState.value.copy(searchText = value))

    fun addStatus(value: AvartarStatus) = setState(uiState.value.copy(status = uiState.value.status.plus(value)))

    fun removeStatus(value: AvartarStatus) = setState(uiState.value.copy(status = uiState.value.status.minus(value)))

    fun addPet(value: AvartarPet) = setState(uiState.value.copy(pets = uiState.value.pets.plus(value)))

    fun removePet(value: AvartarPet) = setState(uiState.value.copy(pets = uiState.value.pets.minus(value)))

    fun buildFindAllAvartarsQueries(): FindAllAvartarQueriesRequestModel {
        val status = uiState.value.status.joinToString(",")
        val pets = uiState.value.pets.joinToString(",")

        return FindAllAvartarQueriesRequestModel(
            searchText = uiState.value.searchText,
            status = status,
            pets = pets,
        )
    }
}