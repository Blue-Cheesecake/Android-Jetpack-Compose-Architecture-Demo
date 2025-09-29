package com.sinut.androidsamplearch.domain.usecase

import com.sinut.core_data.api.biometric.data.datasource.BiometricDataSource
import com.sinut.core_data.core.base.BaseUseCase
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import javax.inject.Inject

class InitialBiometricAuthUseCase @Inject constructor(
    private val biometricDataSource: BiometricDataSource,
    private val dataStore: AppPreferencesDataSource,
) : BaseUseCase<Unit, String>() {
    override suspend fun call(params: Unit): String {
//        val postChallengeRequest = BiometricChallengeRequestModel(
//            deviceId = "abc13acb-5abd-47b6-9587-5c1b490a3f39", // mock device id
//        )
//
//        val challengeResult = biometricDataSource.postChallenge(postChallengeRequest)
//
//        challengeResult.result.challenge
//
//        CryptoKeyManager.convertBase64ToPrivateKey(dataStore.getPrivateKey())
//
//        CryptoKeyManager.signMessage()
        return ""
    }

}