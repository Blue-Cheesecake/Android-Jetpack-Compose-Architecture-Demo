package com.sinut.core_data.local.storage.model

import androidx.datastore.core.Serializer
import com.sinut.core_data.core.manager.CryptoManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import java.util.Base64

@Serializable
data class AppPreferences(
    val privateKey: String? = null
)

object AppPreferencesSerializer : Serializer<AppPreferences> {
    override val defaultValue: AppPreferences get() = AppPreferences()

    override suspend fun readFrom(input: InputStream): AppPreferences {
        val encryptedBytes = withContext(Dispatchers.IO) {
            input.use { it.readBytes() }
        }
        val encryptedBytesDecoded = Base64.getDecoder().decode(encryptedBytes)
        val decryptedBytes = CryptoManager.decrypt(encryptedBytesDecoded)
        val decodedJsonStr = decryptedBytes.decodeToString()
        val result = Json.decodeFromString<AppPreferences>(decodedJsonStr)
        return result
    }

    override suspend fun writeTo(t: AppPreferences, output: OutputStream) {
        val json = Json.encodeToString(AppPreferences.serializer(), t)
        val bytes = json.toByteArray()
        val encryptedBytes = CryptoManager.encrypt(bytes)
        val encryptedBytesBase64 = Base64.getEncoder().encode(encryptedBytes)
        withContext(Dispatchers.IO) {
            output.use { it.write(encryptedBytesBase64) }
        }
    }
}