package com.sinut.androidsamplearch.features.auth.presentation.logic.api

import androidx.lifecycle.viewModelScope
import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.androidsamplearch.core.constants.CommonMessage
import com.sinut.androidsamplearch.domain.usecase.EnableBiometricAuthUseCase
import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val enableBiometricAuthUseCase: EnableBiometricAuthUseCase
) :
    BaseViewModel<LoginUiState>(LoginUiState()) {

    fun login(username: String, password: String) {
        setState { it.copy(loginApiState = LoginApiState.Loading) }
        val request = LoginRequestModel(username, password)

        viewModelScope.launch {
            loginUseCase.execute(request)
                .onSuccess { result ->
                    setState { it.copy(loginApiState = LoginApiState.Success(result.token)) }
                }
                .onFailure { err ->
                    setState {
                        it.copy(
                            loginApiState = LoginApiState.Error(
                                err.message ?: CommonMessage.SOMETHING_WRONG
                            )
                        )
                    }
                }
        }
    }

    fun invalidate() = setState { it.copy(loginApiState = LoginApiState.Idle) }

    fun enableBiometric() {
        setState { it.copy(enableBioAuthState = EnableBioAuthState.Loading) }

        viewModelScope.launch {
            enableBiometricAuthUseCase.execute(Unit)
                .onSuccess { response ->
                    setState {
                        it.copy(
                            enableBioAuthState = EnableBioAuthState.Success(
                                response
                            )
                        )
                    }
                }
                .onFailure { err ->
                    setState {
                        it.copy(
                            enableBioAuthState = EnableBioAuthState.Error(
                                err.message ?: CommonMessage.SOMETHING_WRONG
                            )
                        )
                    }
                }
        }
    }
}