package com.sinut.androidsamplearch.domain.di

import com.sinut.androidsamplearch.domain.usecase.EnableBiometricAuthUseCase
import com.sinut.androidsamplearch.domain.usecase.GenerateKeypairUseCase
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
    fun providesGenerateKeypairUseCase(): GenerateKeypairUseCase {
        return GenerateKeypairUseCase()
    }

    @Provides
    @ViewModelScoped
    fun providesEnableBiometricAuthUseCase(
        generateKeypairUseCase: GenerateKeypairUseCase,
        appPreferencesDataSource: AppPreferencesDataSource,
        biometricDataSource: BiometricDataSource,
    ): EnableBiometricAuthUseCase {
        return EnableBiometricAuthUseCase(
            generateKeypairUseCase,
            appPreferencesDataSource,
            biometricDataSource
        )
    }
}