package com.sinut.androidsamplearch.features.auth.presentation.logic.api

import androidx.lifecycle.viewModelScope
import com.sinut.androidsamplearch.core.base.BaseViewModel
import com.sinut.androidsamplearch.core.constants.CommonMessage
import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginApiViewModel @Inject constructor(private val loginUseCase: LoginUseCase) :
    BaseViewModel<LoginApiState>(LoginApiState.Idle) {

    fun login(username: String, password: String) {
        setState(LoginApiState.Loading)
        val request = LoginRequestModel(username, password)

        viewModelScope.launch {
            val response = loginUseCase.execute(request)

            response.onSuccess {
                setState(LoginApiState.Success(it.token))
            }
            response.onFailure {
                setState(LoginApiState.Error(it.message ?: CommonMessage.SOMETHING_WRONG))
            }
        }
    }

    fun invalidate() = setState(LoginApiState.Idle)
}