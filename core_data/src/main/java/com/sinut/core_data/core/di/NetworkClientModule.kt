package com.sinut.core_data.core.di

import com.sinut.core_data.core.network.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkClientModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return NetworkClient.retrofit
    }
}