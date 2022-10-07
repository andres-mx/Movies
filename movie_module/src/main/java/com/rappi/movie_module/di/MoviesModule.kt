package com.rappi.movie_module.di

import android.content.Context
import androidx.room.Room
import com.rappi.movie_module.data.MovieService
import com.rappi.movie_module_api.database.MovieModel
import com.rappi.movie_module_api.database.MoviesDao
import com.rappi.movie_module_api.database.MoviesDatabase
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
class MoviesModule {
    @Provides
    fun provideMovieService(@NetworkRetrofit retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            MoviesDatabase::class.java.name
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesDao(moviesDatabase: MoviesDatabase): MoviesDao {
        return moviesDatabase.getMoviesDao()
    }
}