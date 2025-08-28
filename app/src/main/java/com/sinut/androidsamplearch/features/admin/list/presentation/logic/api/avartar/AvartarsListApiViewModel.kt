package com.sinut.androidsamplearch.features.admin.list.presentation.logic.api.avartar

import androidx.lifecycle.viewModelScope
import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.androidsamplearch.core.constants.CommonMessage
import com.sinut.core_data.api.avartar.data.models.FindAllAvartarQueriesRequestModel
import com.sinut.core_data.api.avartar.domain.usecases.FindAllAvartarsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AvartarsListApiViewModel @Inject constructor(private val findAllAvartarsUseCase: FindAllAvartarsUseCase) :
    BaseViewModel<AvartarsListApiState>(AvartarsListApiState.Idle) {


    fun fetch(queries: FindAllAvartarQueriesRequestModel) {
        setState(AvartarsListApiState.Loading)

        viewModelScope.launch {
            val response = findAllAvartarsUseCase.execute(queries)

            response
                .onSuccess { list ->
                    setState(AvartarsListApiState.Success(list))
                }
                .onFailure { error ->
                    setState(AvartarsListApiState.Error(error.message ?: CommonMessage.SOMETHING_WRONG))
                }
        }
    }
}