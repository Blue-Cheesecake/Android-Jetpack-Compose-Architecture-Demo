package com.sinut.androidsamplearch.core.di

import com.sinut.androidsamplearch.core.network.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object NetworkClientModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return NetworkClient.retrofit
    }
}