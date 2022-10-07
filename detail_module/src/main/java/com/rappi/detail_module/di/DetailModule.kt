package com.rappi.detail_module.di

import android.content.Context
import androidx.room.Room
import com.rappi.detail_module.data.MovieDetailService
import com.rappi.detail_module_api.database.MovieDetailDao
import com.rappi.detail_module_api.database.MovieDetailDatabase
import com.rappi.network_module_api.NetworkRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailModule {
    @Provides
    fun provideMovieDetailService(@NetworkRetrofit retrofit: Retrofit): MovieDetailService =
        retrofit.create(MovieDetailService::class.java)

    @Singleton
    @Provides
    fun provideMovieDetailDatabase(@ApplicationContext context: Context): MovieDetailDatabase {
        return Room.databaseBuilder(
            context,
            MovieDetailDatabase::class.java,
            MovieDetailDatabase::class.java.name
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDetailDao(movieDetailDatabase: MovieDetailDatabase): MovieDetailDao {
        return movieDetailDatabase.getMovieDetailDao()
    }
}