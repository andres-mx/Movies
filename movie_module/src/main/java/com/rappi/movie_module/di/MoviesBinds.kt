package com.rappi.movie_module.di

import com.rappi.movie_module.data.MovieApiImpl
import com.rappi.movie_module.domain.GetRecommendedUseCaseImpl
import com.rappi.movie_module.domain.GetTopRatedUseCaseImpl
import com.rappi.movie_module.domain.GetUpcomingUseCaseImpl
import com.rappi.movie_module.repository.MoviesRepositoryImpl
import com.rappi.movie_module_api.domain.GetMoviesUseCase
import com.rappi.movie_module_api.Upcoming
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.TopRated
import com.rappi.movie_module_api.data.MovieApi
import com.rappi.movie_module_api.domain.GetRecommendedUseCase
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
    abstract fun bindsRecommended(getRecommendedUseCaseImpl: GetRecommendedUseCaseImpl): GetRecommendedUseCase

    @Binds
    abstract fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindsMoviesApi(movieApiImpl: MovieApiImpl): MovieApi
}