package com.sinut.androidsamplearch.features.auth.domain.repositories

import com.sinut.androidsamplearch.features.auth.data.datasources.ILoginDataSource
import com.sinut.androidsamplearch.features.auth.data.models.LoginRequestModel
import com.sinut.androidsamplearch.features.auth.data.models.LoginResponseModel
import javax.inject.Inject

interface ILoginRepository {
    suspend fun login(request: LoginRequestModel): LoginResponseModel
}

class LoginRepository @Inject constructor(private val dataSource: ILoginDataSource) : ILoginRepository {
    override suspend fun login(request: LoginRequestModel): LoginResponseModel {
        val response = dataSource.login(request)
        return response
    }
}