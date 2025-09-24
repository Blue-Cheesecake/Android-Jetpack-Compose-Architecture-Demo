package com.sinut.androidsamplearch.domain.usecase

import android.media.MediaDrm
import com.sinut.core_data.api.biometric.data.datasource.BiometricDataSource
import com.sinut.core_data.api.biometric.data.model.BioMetricResponseWithResultModel
import com.sinut.core_data.api.biometric.data.model.BiometricRequestModel
import com.sinut.core_data.core.base.BaseUseCase
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import java.util.Base64
import java.util.UUID

class EnableBiometricAuthUseCase(
    private val generateKeypairUseCase: GenerateKeypairUseCase,
    private val appPreferencesDataSource: AppPreferencesDataSource,
    private val biometricDataSource: BiometricDataSource,
) : BaseUseCase<Unit, BioMetricResponseWithResultModel>() {
    companion object {
        private val WIDEWINE_UUID = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
    }

    private val drm = MediaDrm(WIDEWINE_UUID)

    override suspend fun call(params: Unit): BioMetricResponseWithResultModel {
        val keypair = generateKeypairUseCase.execute(Unit).getOrThrow()

        appPreferencesDataSource.setPrivateKey(keypair.private)

        val deviceIdBytes = drm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)

        val encoder = Base64.getEncoder()

        val deviceId = encoder.encodeToString(deviceIdBytes)

        println("deviceId from DRM: $deviceId")

        val request = BiometricRequestModel(
            deviceId = "abc13acb-5abd-47b6-9587-5c1b490a3f39", // mock device id
            publicKey = keypair.public,
        )

        val result = biometricDataSource.postBiometric(request)

        return result
    }

    override fun finallyCb() {
        drm.close()
    }
}

