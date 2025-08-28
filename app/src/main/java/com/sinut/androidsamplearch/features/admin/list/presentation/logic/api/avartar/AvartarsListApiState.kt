package com.sinut.androidsamplearch.features.admin.list.presentation.logic.api.avartar

import com.sinut.core_data.api.avartar.data.models.AvartarInfoModel

sealed class AvartarsListApiState {
    data object Idle : AvartarsListApiState()

    data object Loading : AvartarsListApiState()

    data class Success(val avartars: List<AvartarInfoModel>) : AvartarsListApiState()

    data class Error(val message: String): AvartarsListApiState()
}