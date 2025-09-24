package com.sinut.core_data.api.biometric.data.di

import com.sinut.core_data.api.biometric.data.datasource.BiometricDataSource
import com.sinut.core_data.api.biometric.data.datasource.RetrofitBiometricDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object BiometricModule {

    @Provides
    @ViewModelScoped
    fun providesBiometricDataSource(retrofit: Retrofit): BiometricDataSource {
        return RetrofitBiometricDataSource(retrofit)
    }
}