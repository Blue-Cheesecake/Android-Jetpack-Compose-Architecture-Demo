package com.sinut.core_data.local.storage.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import com.sinut.core_data.local.storage.extension.dataStore
import com.sinut.core_data.local.storage.model.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object LocalStorageModule {

    @Provides
    fun providesDataStore(@ApplicationContext context: Context): DataStore<AppPreferences> {
        return context.dataStore
    }

    @Provides
    fun providesLocalStorageDataSource(dataStore: DataStore<AppPreferences>): AppPreferencesDataSource {
        return AppPreferencesDataSource(dataStore)
    }
}