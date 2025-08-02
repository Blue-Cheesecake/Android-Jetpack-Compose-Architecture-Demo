package com.sinut.androidsamplearch.features.auth.data.datasources

import LoginApiPath
import com.sinut.androidsamplearch.features.auth.data.models.LoginRequestModel
import com.sinut.androidsamplearch.features.auth.data.models.LoginResponseModel
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

private interface ILoginRetrofit {
    @POST(LoginApiPath.login)
    suspend fun login(@Body request: LoginRequestModel): LoginResponseModel
}

interface ILoginDataSource {
    suspend fun login(request: LoginRequestModel): LoginResponseModel
}

class LoginRetrofitDataSource @Inject constructor(private val retrofit: Retrofit) : ILoginDataSource {
    override suspend fun login(request: LoginRequestModel): LoginResponseModel {
        val service = retrofit.create(ILoginRetrofit::class.java)
        val response = service.login(request)
        return response
    }
}