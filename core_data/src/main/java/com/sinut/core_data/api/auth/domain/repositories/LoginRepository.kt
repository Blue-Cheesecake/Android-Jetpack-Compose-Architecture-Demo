package com.sinut.core_data.api.auth.domain.repositories

import com.sinut.core_data.api.auth.data.datasources.LoginDataSource
import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.data.models.LoginResponseModel
import javax.inject.Inject

interface ILoginRepository {
    suspend fun login(request: LoginRequestModel): LoginResponseModel
}

class LoginRepository @Inject constructor(private val dataSource: LoginDataSource) :
    ILoginRepository {
    override suspend fun login(request: LoginRequestModel): LoginResponseModel {
        val response = dataSource.login(request)
        return response
    }
}