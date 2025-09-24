package com.sinut.androidsamplearch.playground

import com.sinut.core_data.core.manager.CryptoKeyManager
import java.util.Base64

fun main() {
    println("Generating keypair...")
    val keypair = CryptoKeyManager.generateKeypair()

    println("\nGenerated Public Key (Base64):\n${keypair.public}")
    println("\nGenerated Private Key (Base64):\n${keypair.private}")

    println("\nConverting Base64 to Private Key object...")
    val privateKeyObject = CryptoKeyManager.convertBase64ToPrivateKey(keypair.private)

    val message = "This is a test message to be signed."
    val base64EncodedMessage = Base64.getEncoder().encodeToString(message.toByteArray())

    println("\nSigning message: \"$message\"...")
    val signature = CryptoKeyManager.signMessageBase64(privateKeyObject, base64EncodedMessage)

    println("\nSignature (Base64):\n$signature")
}