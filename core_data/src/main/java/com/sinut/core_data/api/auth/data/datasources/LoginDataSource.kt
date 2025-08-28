package com.sinut.core_data.api.auth.data.datasources

import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.data.models.LoginResponseModel

interface LoginDataSource {
    suspend fun login(request: LoginRequestModel): LoginResponseModel
}