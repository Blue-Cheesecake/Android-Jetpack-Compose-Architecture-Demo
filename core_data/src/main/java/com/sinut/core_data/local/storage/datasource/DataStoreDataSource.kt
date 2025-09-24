package com.sinut.core_data.local.storage.datasource
//
//import androidx.datastore.core.DataStore
//import androidx.datastore.preferences.core.Preferences
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.core.stringPreferencesKey
//import kotlinx.coroutines.flow.first
//import javax.inject.Inject
//
//class DataStoreDataSource @Inject constructor(private val dataStore: DataStore<Preferences>) :
//    LocalStorageDataSource {
//    override suspend fun get(key: String): String? {
//        val key = stringPreferencesKey(key)
//        val value = dataStore.data.first()[key]
//        return value
//    }
//
//    override suspend fun set(key: String, value: String) {
//        val key = stringPreferencesKey(key)
//        dataStore.edit { it[key] = value }
//    }
//}