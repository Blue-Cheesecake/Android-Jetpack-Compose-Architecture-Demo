package com.sinut.core_data.api.biometric.data.datasource

import com.sinut.core_data.api.biometric.data.model.BioMetricResponseWithResultModel
import com.sinut.core_data.api.biometric.data.model.BiometricAuthenRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricAuthenResponseModel
import com.sinut.core_data.api.biometric.data.model.BiometricChallengeRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricPostChallengeResponseModel
import com.sinut.core_data.api.biometric.data.model.BiometricRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricResponseModel

interface BiometricDataSource {
    suspend fun postBiometric(req: BiometricRequestModel): BioMetricResponseWithResultModel

    suspend fun deleteBiometric(req: BiometricRequestModel): BiometricResponseModel

    suspend fun postChallenge(req: BiometricChallengeRequestModel): BiometricPostChallengeResponseModel

    suspend fun postAuthenticate(req: BiometricAuthenRequestModel): BiometricAuthenResponseModel
}