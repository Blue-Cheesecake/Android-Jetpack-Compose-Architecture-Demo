package com.sinut.core_data.api.avartar.di

import AvartarNetworkDataSource
import com.sinut.core_data.api.avartar.data.datasources.AvartarDataSource
import com.sinut.core_data.api.avartar.domain.repositories.AvartarRepository
import com.sinut.core_data.api.avartar.domain.repositories.AvartarRepositoryImpl
import com.sinut.core_data.api.avartar.domain.usecases.FindAllAvartarsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object AvartarModule {

    @Provides
    @ViewModelScoped
    fun provideAvartarDataSource(retrofit: Retrofit): AvartarDataSource {
        return AvartarNetworkDataSource(retrofit)
    }

    @Provides
    @ViewModelScoped
    fun provideAvartarRepository(dataSource: AvartarDataSource): AvartarRepository {
        return AvartarRepositoryImpl(dataSource)
    }

    @Provides
    @ViewModelScoped
    fun provideFindAllAvartarsUseCase(repository: AvartarRepository): FindAllAvartarsUseCase {
        return FindAllAvartarsUseCase(repository)
    }
}