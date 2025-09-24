package com.sinut.core_data.local.storage.datasource

import androidx.datastore.core.DataStore
import com.sinut.core_data.local.storage.model.AppPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AppPreferencesDataSource @Inject constructor(private val dataStore: DataStore<AppPreferences>) {

    suspend fun getPrivateKey(): String? {
        return dataStore.data.first().privateKey
    }

    suspend fun setPrivateKey(value: String) {
        dataStore.updateData { it.copy(privateKey = value) }
    }
}