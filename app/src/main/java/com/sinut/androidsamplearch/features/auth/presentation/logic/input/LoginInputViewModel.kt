package com.sinut.androidsamplearch.features.auth.presentation.logic.input

import com.sinut.androidsamplearch.core.base.BaseViewModel

class LoginInputViewModel : BaseViewModel<LoginInputState>(LoginInputState()) {

    fun updateUsername(value: String) = setState(uiState.value.copy(username = value))

    fun updatePassword(value: String) = setState(uiState.value.copy(password = value))
}