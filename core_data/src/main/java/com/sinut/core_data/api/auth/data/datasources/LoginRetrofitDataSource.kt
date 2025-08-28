package com.sinut.core_data.api.auth.data.datasources

import com.sinut.core_data.api.auth.constants.LoginApiPath
import com.sinut.core_data.api.auth.data.models.LoginRequestModel
import com.sinut.core_data.api.auth.data.models.LoginResponseModel
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Inject

private interface LoginRetrofit {
    @POST(LoginApiPath.LOGIN)
    suspend fun login(@Body request: LoginRequestModel): LoginResponseModel
}

class LoginRetrofitDataSource @Inject constructor(private val retrofit: Retrofit) : LoginDataSource {
    override suspend fun login(request: LoginRequestModel): LoginResponseModel {
        val service = retrofit.create(LoginRetrofit::class.java)
        // delay for demo purposes
        delay(1000L)

        val response = service.login(request)
        return response
    }
}