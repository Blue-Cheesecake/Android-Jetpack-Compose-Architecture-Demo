package com.sinut.androidsamplearch.features.auth.presentation.logic.api

sealed class LoginApiState {
    data object Idle : LoginApiState()

    data object Loading : LoginApiState()

    data class Success(val token: String) : LoginApiState()

    data class Error(val message: String) : LoginApiState()
}