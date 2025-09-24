package com.sinut.androidsamplearch.domain.usecase

import com.sinut.core_data.api.biometric.data.datasource.BiometricDataSource
import com.sinut.core_data.api.biometric.data.model.BiometricRequestModel
import com.sinut.core_data.api.biometric.data.model.BiometricResponseModel
import com.sinut.core_data.core.base.BaseUseCase
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource

class DisableBiometricAuthUseCase(
    private val appPreferencesDataSource: AppPreferencesDataSource,
    private val biometricDataSource: BiometricDataSource,
) : BaseUseCase<Unit, BiometricResponseModel>() {
    override suspend fun call(params: Unit): BiometricResponseModel {
        appPreferencesDataSource.setPrivateKey(null)

        println("curr private key (should be null): ${appPreferencesDataSource.getPrivateKey()}")

        val request = BiometricRequestModel(
            deviceId = "abc13acb-5abd-47b6-9587-5c1b490a3f39", // mock device id
        )

        val response = biometricDataSource.deleteBiometric(request)

        return response
    }
}