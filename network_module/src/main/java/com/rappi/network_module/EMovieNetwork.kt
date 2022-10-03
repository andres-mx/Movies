package com.rappi.network_module

import com.rappi.network_module_api.NetworkModule
import com.rappi.network_module_api.NetworkOkHttpClient
import com.rappi.network_module_api.NetworkRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class EMovieNetwork : NetworkModule {
    @Singleton
    @Provides
    override fun networkClient(@NetworkOkHttpClient baseOkHttpClient: OkHttpClient.Builder): OkHttpClient =
        baseOkHttpClient.build()

    @Singleton
    @Provides
    @NetworkRetrofit
    override fun networkRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.THEMOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    @NetworkOkHttpClient
    fun provideEMovieOkHttpSessionBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .readTimeout(20000, TimeUnit.MILLISECONDS)
            .connectTimeout(20000, TimeUnit.MILLISECONDS)
    }
}