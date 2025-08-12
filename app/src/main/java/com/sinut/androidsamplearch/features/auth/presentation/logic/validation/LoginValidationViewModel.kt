package com.sinut.androidsamplearch.features.auth.presentation.logic.validation

import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.androidsamplearch.features.auth.presentation.logic.input.LoginInputState

class LoginValidationViewModel : BaseViewModel<LoginValidationState>(LoginValidationState()) {

    fun validate(inputs: LoginInputState): Boolean {
        var tmp = LoginValidationState()
        var isValid = true

        if (inputs.username.isBlank()) {
            tmp = tmp.copy(usernameErrorText = "Username is required")
            isValid = false
        }
        if (inputs.password.isBlank()) {
            tmp = tmp.copy(passwordErrorText = "Password is required")
            isValid = false
        }

        setState(tmp)
        return isValid
    }
}