package com.sinut.androidsamplearch.domain.model

data class Base64EncodedKeypairModel(
    val public: String,
    val private: String,
) {
    val publicPEM: String get() = "-----BEGIN PUBLIC KEY-----\n$public\n-----END PUBLIC KEY-----"
}