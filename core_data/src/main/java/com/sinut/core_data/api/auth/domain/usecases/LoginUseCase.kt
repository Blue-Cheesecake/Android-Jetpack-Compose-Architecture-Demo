package com.sinut.core_data.api.auth.domain.usecases

import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.data.models.LoginResponseModel
import com.sinut.core_data.api.auth.domain.repositories.ILoginRepository
import com.sinut.core_data.core.base.BaseUseCase

import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: ILoginRepository) :
    BaseUseCase<LoginRequestModel, LoginResponseModel>() {

    override suspend fun call(params: LoginRequestModel): LoginResponseModel {
        val response = repository.login(params)
        return response
    }
}