package com.rappi.detail_module.di

import com.rappi.detail_module.data.MovieDetailService
import com.rappi.network_module_api.NetworkRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class DetailModule {
    @Provides
    fun provideMovieDetailService(@NetworkRetrofit retrofit: Retrofit): MovieDetailService =
        retrofit.create(MovieDetailService::class.java)
}