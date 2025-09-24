package com.sinut.androidsamplearch.features.auth.presentation.logic.api

data class LoginUiState(
    val loginApiState: LoginApiState = LoginApiState.Idle,
    val enableBioAuthState: EnableBioAuthState = EnableBioAuthState.Idle,
)

sealed class LoginApiState {
    data object Idle : LoginApiState()

    data object Loading : LoginApiState()

    data class Success(val token: String) : LoginApiState()

    data class Error(val message: String) : LoginApiState()
}

sealed class EnableBioAuthState {
    data object Idle : EnableBioAuthState()

    data object Loading : EnableBioAuthState()

    data object Success : EnableBioAuthState()

    data class Error(val message: String) : EnableBioAuthState()
}