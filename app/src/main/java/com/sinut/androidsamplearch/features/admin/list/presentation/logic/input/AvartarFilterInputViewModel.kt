package com.sinut.androidsamplearch.features.admin.list.presentation.logic.input

import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.core_data.api.avartar.constants.AvartarPet
import com.sinut.core_data.api.avartar.constants.AvartarStatus
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel

class AvartarFilterInputViewModel : BaseViewModel<AvartarFilterInputState>(AvartarFilterInputState()) {

    fun updateSearchText(value: String?) = setState(uiState.value.copy(searchText = value))

    fun onInitialStatus() = setState(uiState.value.copy(tempStatus = uiState.value.status.toList()))

    fun onAddStatus(value: AvartarStatus) =
        setState(uiState.value.copy(tempStatus = uiState.value.tempStatus.plus(value)))

    fun onRemoveStatus(value: AvartarStatus) =
        setState(uiState.value.copy(tempStatus = uiState.value.tempStatus.minus(value)))

    fun onApplyStatus() = setState(uiState.value.copy(status = uiState.value.tempStatus.toList()))

    fun onCancelStatus() = setState(uiState.value.copy(tempStatus = emptyList()))

    fun onInitialPet() = setState(uiState.value.copy(tempPets = uiState.value.pets.toList()))

    fun onAddPet(value: AvartarPet) = setState(uiState.value.copy(tempPets = uiState.value.tempPets.plus(value)))

    fun onRemovePet(value: AvartarPet) = setState(uiState.value.copy(tempPets = uiState.value.tempPets.minus(value)))

    fun onApplyPet() = setState(uiState.value.copy(pets = uiState.value.tempPets.toList()))

    fun onCancelPet() = setState(uiState.value.copy(tempPets = emptyList()))

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