package com.sinut.androidsamplearch.domain.usecase

import android.media.MediaDrm
import com.sinut.core_data.core.base.BaseUseCase
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import java.util.Base64
import java.util.UUID

class EnableBiometricAuthUseCase(
    private val generateKeypairUseCase: GenerateKeypairUseCase,
    private val appPreferencesDataSource: AppPreferencesDataSource,
) : BaseUseCase<Unit, Unit>() {
    private val widewineUuid = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
    private val drm = MediaDrm(widewineUuid)

    override suspend fun call(params: Unit) {
        val keypair = generateKeypairUseCase.execute(Unit).getOrThrow()

        appPreferencesDataSource.setPrivateKey(keypair.private)

        val deviceIdBytes = drm.getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)

        val encoder = Base64.getEncoder()

        val deviceId = encoder.encodeToString(deviceIdBytes)

        println("deviceId: $deviceId")
    }

    override fun finallyCb() {
        drm.close()
    }
}

