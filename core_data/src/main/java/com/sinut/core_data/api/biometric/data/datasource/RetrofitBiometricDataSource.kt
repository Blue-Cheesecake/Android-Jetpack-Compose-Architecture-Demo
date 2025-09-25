package com.sinut.core_data.api.biometric.data.datasource

import com.sinut.core_data.api.biometric.data.constant.BiometricApiPath
import com.sinut.core_data.api.biometric.data.model.BioMetricResponseWithResultModel
import com.sinut.core_data.api.biometric.data.model.BiometricChallengeRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricPostChallengeResponseModel
import com.sinut.core_data.api.biometric.data.model.BiometricRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricResponseModel
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.POST
import javax.inject.Inject

private interface BiometricRetrofit {
    @POST(BiometricApiPath.MAIN)
    suspend fun postBiometric(@Body req: BiometricRequestModel): BioMetricResponseWithResultModel

    @HTTP(method = "DELETE", path = BiometricApiPath.MAIN, hasBody = true)
    suspend fun deleteBiometric(@Body req: BiometricRequestModel): BiometricResponseModel

    @POST(BiometricApiPath.CHALLENGE)
    suspend fun postChallenge(@Body req: BiometricChallengeRequestModel): BiometricPostChallengeResponseModel
}

class RetrofitBiometricDataSource @Inject constructor(private val retrofit: Retrofit) :
    BiometricDataSource {
    override suspend fun postBiometric(req: BiometricRequestModel): BioMetricResponseWithResultModel {
        val service = retrofit.create(BiometricRetrofit::class.java)
        val response = service.postBiometric(req)
        return response
    }

    override suspend fun deleteBiometric(req: BiometricRequestModel): BiometricResponseModel {
        val service = retrofit.create(BiometricRetrofit::class.java)
        val response = service.deleteBiometric(req)
        return response
    }

    override suspend fun postChallenge(req: BiometricChallengeRequestModel): BiometricPostChallengeResponseModel {
        val service = retrofit.create(BiometricRetrofit::class.java)
        val response = service.postChallenge(req)
        return response
    }
}