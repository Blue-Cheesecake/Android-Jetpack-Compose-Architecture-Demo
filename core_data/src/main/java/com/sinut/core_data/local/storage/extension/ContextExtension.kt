package com.sinut.core_data.local.storage.extension

import android.content.Context
import androidx.datastore.dataStore
import com.sinut.core_data.local.storage.model.AppPreferencesSerializer

val Context.dataStore by dataStore(
    fileName = "com.sample.app.preferences",
    serializer = AppPreferencesSerializer
)