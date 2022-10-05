package com.rappi.trailer_module.di

import com.rappi.network_module_api.NetworkRetrofit
import com.rappi.trailer_module.data.TrailerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class TrailerModule {
    @Provides
    fun provideTrailerService(@NetworkRetrofit retrofit: Retrofit): TrailerService =
        retrofit.create(TrailerService::class.java)
}