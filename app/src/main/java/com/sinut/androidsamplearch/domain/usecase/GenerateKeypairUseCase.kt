package com.sinut.androidsamplearch.domain.usecase

import com.sinut.androidsamplearch.domain.model.Base64EncodedKeypairModel
import com.sinut.core_data.core.base.BaseUseCase
import java.security.KeyPairGenerator
import java.security.SecureRandom
import java.util.Base64

class GenerateKeypairUseCase : BaseUseCase<Unit, Base64EncodedKeypairModel>() {

    override suspend fun call(params: Unit): Base64EncodedKeypairModel {
        val generator = KeyPairGenerator.getInstance("RSA")

        generator.initialize(2048, SecureRandom())

        val keypair = generator.genKeyPair()

        val encoder = Base64.getEncoder()

        return Base64EncodedKeypairModel(
            public = encoder.encodeToString(keypair.public.encoded),
            private = encoder.encodeToString(keypair.private.encoded)
        )
    }
}