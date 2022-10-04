package com.rappi.movie_module.di

import com.rappi.movie_module.data.MovieService
import com.rappi.network_module_api.NetworkRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class MovieDetailModule {
    @Provides
    fun provideMovieService(@NetworkRetrofit retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)
}