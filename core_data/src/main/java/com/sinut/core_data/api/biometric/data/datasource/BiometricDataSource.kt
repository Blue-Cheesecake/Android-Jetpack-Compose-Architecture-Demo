package com.sinut.core_data.api.biometric.data.datasource

import com.sinut.core_data.api.biometric.data.model.BioMetricResponseWithResultModel
import com.sinut.core_data.api.biometric.data.model.BiometricChallengeRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricPostChallengeResponseModel
import com.sinut.core_data.api.biometric.data.model.BiometricRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricResponseModel

interface BiometricDataSource {
    suspend fun postBiometric(req: BiometricRequestModel): BioMetricResponseWithResultModel

    suspend fun deleteBiometric(req: BiometricRequestModel): BiometricResponseModel

    suspend fun postChallenge(req: BiometricChallengeRequestModel): BiometricPostChallengeResponseModel
}