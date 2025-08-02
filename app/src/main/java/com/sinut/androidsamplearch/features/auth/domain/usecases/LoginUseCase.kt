package com.sinut.androidsamplearch.features.auth.domain.usecases

import com.sinut.androidsamplearch.core.base.BaseUseCase
import com.sinut.androidsamplearch.features.auth.data.models.LoginRequestModel
import com.sinut.androidsamplearch.features.auth.data.models.LoginResponseModel
import com.sinut.androidsamplearch.features.auth.domain.repositories.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: ILoginRepository) :
    BaseUseCase<LoginRequestModel, LoginResponseModel>() {

    override suspend fun call(params: LoginRequestModel): LoginResponseModel {
        val response = repository.login(params)
        return response
    }
}