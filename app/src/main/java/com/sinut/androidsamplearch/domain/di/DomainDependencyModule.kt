package com.sinut.androidsamplearch.domain.di

import com.sinut.androidsamplearch.domain.usecase.DisableBiometricAuthUseCase
import com.sinut.androidsamplearch.domain.usecase.EnableBiometricAuthUseCase
import com.sinut.core_data.api.biometric.data.datasource.BiometricDataSource
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object DomainDependencyModule {

    @Provides
    @ViewModelScoped
    fun providesEnableBiometricAuthUseCase(
        appPreferencesDataSource: AppPreferencesDataSource,
        biometricDataSource: BiometricDataSource,
    ): EnableBiometricAuthUseCase {
        return EnableBiometricAuthUseCase(
            appPreferencesDataSource,
            biometricDataSource
        )
    }

    @Provides
    @ViewModelScoped
    fun provideDisableBiometricAuthUseCase(
        appPreferencesDataSource: AppPreferencesDataSource,
        biometricDataSource: BiometricDataSource,
    ): DisableBiometricAuthUseCase {
        return DisableBiometricAuthUseCase(appPreferencesDataSource, biometricDataSource)
    }
}