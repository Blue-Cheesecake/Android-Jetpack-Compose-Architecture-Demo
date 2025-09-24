package com.sinut.androidsamplearch.domain.di

import com.sinut.androidsamplearch.domain.usecase.EnableBiometricAuthUseCase
import com.sinut.androidsamplearch.domain.usecase.GenerateKeypairUseCase
import com.sinut.core_data.local.storage.datasource.AppPreferencesDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DomainDependencyModule {

    @Provides
    fun providesGenerateKeypairUseCase(): GenerateKeypairUseCase {
        return GenerateKeypairUseCase()
    }

    @Provides
    fun providesEnableBiometricAuthUseCase(
        generateKeypairUseCase: GenerateKeypairUseCase,
        appPreferencesDataSource: AppPreferencesDataSource
    ): EnableBiometricAuthUseCase {
        return EnableBiometricAuthUseCase(generateKeypairUseCase, appPreferencesDataSource)
    }
}