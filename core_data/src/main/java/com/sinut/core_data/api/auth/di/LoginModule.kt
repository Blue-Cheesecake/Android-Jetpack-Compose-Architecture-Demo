package com.sinut.core_data.api.auth.di

import com.sinut.core_data.api.auth.data.datasources.ILoginDataSource
import com.sinut.core_data.api.auth.data.datasources.LoginRetrofitDataSource
import com.sinut.core_data.api.auth.domain.repositories.ILoginRepository
import com.sinut.core_data.api.auth.domain.repositories.LoginRepository
import com.sinut.core_data.api.auth.domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object LoginModule {

    @Provides
    @ViewModelScoped
    fun provideLoginDataSource(retrofit: Retrofit): ILoginDataSource {
        return LoginRetrofitDataSource(retrofit)
    }

    @Provides
    @ViewModelScoped
    fun provideLoginRepository(dataSource: ILoginDataSource): ILoginRepository {
        return LoginRepository(dataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideLoginUseCase(repository: ILoginRepository): LoginUseCase {
        return LoginUseCase(repository)
    }
}