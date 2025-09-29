package com.sinut.core_data.core.manager

import com.sinut.core_data.core.data.models.Base64EncodedKeypairModel
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.SecureRandom
import java.security.Signature
import java.security.spec.ECGenParameterSpec
import java.security.spec.PKCS8EncodedKeySpec
import java.util.Base64

object CryptoKeyManager {

    fun generateKeypair(): Base64EncodedKeypairModel {
        val generator = KeyPairGenerator.getInstance("EC")

        val ecSpec = ECGenParameterSpec("secp256r1")

        generator.initialize(ecSpec, SecureRandom())

        val keypair = generator.genKeyPair()

        val encoder = Base64.getEncoder()

        return Base64EncodedKeypairModel(
            public = encoder.encodeToString(keypair.public.encoded),
            private = encoder.encodeToString(keypair.private.encoded)
        )
    }

    fun convertBase64ToPrivateKey(base64: String): PrivateKey {
        val decodedBytes = Base64.getDecoder().decode(base64)

        val keySpec = PKCS8EncodedKeySpec(decodedBytes)

        val keyFactory = KeyFactory.getInstance("EC")

        val privateKey = keyFactory.generatePrivate(keySpec)

        return privateKey
    }

    fun signMessage(privateKey: PrivateKey, data: String): String {
        val decodedBytes = data.toByteArray(Charsets.UTF_8)

        val signedBytes = signMessage(privateKey, decodedBytes)

        val encoder = Base64.getEncoder()

        return encoder.encodeToString(signedBytes)
    }

    fun signMessage(privateKey: PrivateKey, data: ByteArray): ByteArray {
        val signature = Signature.getInstance("SHA256withECDSA")

        signature.initSign(privateKey)

        signature.update(data)

        return signature.sign()
    }
}