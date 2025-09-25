package com.sinut.androidsamplearch.features.auth.presentation.logic.api

import com.sinut.core_data.api.biometric.data.model.BioMetricResponseWithResultModel
import com.sinut.core_data.api.biometric.data.model.BiometricResponseModel

data class LoginUiState(
    val loginApiState: LoginApiState = LoginApiState.Idle,
    val enableBioAuthState: EnableBioAuthState = EnableBioAuthState.Idle,
    val disableBioAuthState: DisableBioAuthState = DisableBioAuthState.Idle,
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

    data class Success(val result: BioMetricResponseWithResultModel) : EnableBioAuthState()

    data class Error(val message: String) : EnableBioAuthState()
}

sealed class DisableBioAuthState {
    data object Idle : DisableBioAuthState()

    data object Loading : DisableBioAuthState()

    data class Success(val result: BiometricResponseModel) : DisableBioAuthState()

    data class Error(val message: String) : DisableBioAuthState()
}