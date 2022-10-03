package com.rappi.movie_module.di

import com.rappi.movie_module.data.MovieApiImpl
import com.rappi.movie_module.domain.GetTopRatedUseCaseImpl
import com.rappi.movie_module.domain.GetUpcomingUseCaseImpl
import com.rappi.movie_module.repository.MoviesRepositoryImpl
import com.rappi.movie_module_api.GetMoviesUseCase
import com.rappi.movie_module_api.Upcoming
import com.rappi.movie_module_api.MoviesRepository
import com.rappi.movie_module_api.TopRated
import com.rappi.movie_module_api.data.MovieApi
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesBinds {

    @Upcoming
    @Binds
    abstract fun bindsUpcoming(getUpcomingUseCaseImpl: GetUpcomingUseCaseImpl): GetMoviesUseCase

    @TopRated
    @Binds
    abstract fun bindsTopRated(getTopRatedUseCaseImpl: GetTopRatedUseCaseImpl): GetMoviesUseCase

    @Binds
    abstract fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindsMoviesApi(movieApiImpl: MovieApiImpl): MovieApi
}