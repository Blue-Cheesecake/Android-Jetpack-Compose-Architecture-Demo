package com.sinut.androidsamplearch.playground

import com.sinut.core_data.core.manager.CryptoKeyManager

fun main() {
    println("Generating keypair...")
    val keypair = CryptoKeyManager.generateKeypair()

    println("\nGenerated Private Key (Base64):\n${keypair.private}")
    println("\nGenerated Public Key PEM (Base64):\n${keypair.publicPEM}")

    println("\nConverting Base64 to Private Key object...")
    val privateKeyObject = CryptoKeyManager.convertBase64ToPrivateKey(keypair.private)

    val message = "PudZyuIzbgwKkDYJrpeUum233EF1iqnTEetVEX07ufw"

    println("\nSigning message with standard DER encoding...")
    val derSignature = CryptoKeyManager.signMessage(privateKeyObject, message)
    println(derSignature)
}