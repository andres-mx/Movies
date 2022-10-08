package com.rappi.movie_module.di

import com.rappi.movie_module.data.LocalMovieSourceImpl
import com.rappi.movie_module.data.MovieApiImpl
import com.rappi.movie_module.domain.*
import com.rappi.movie_module.repository.MoviesRepositoryImpl
import com.rappi.movie_module_api.Upcoming
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.TopRated
import com.rappi.movie_module_api.data.LocalMovieSource
import com.rappi.movie_module_api.data.MovieApi
import com.rappi.movie_module_api.domain.*
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
    abstract fun bindsGetRecommendedByYearUseCase(getRecommendedByYearUseCaseImpl: GetRecommendedByYearUseCaseImpl): GetRecommendedByYearUseCase

    @Binds
    abstract fun bindsGetRecommendedByLanguageUseCase(getRecommendedByLanguageUseCaseImpl: GetRecommendedByLanguageUseCaseImpl): GetRecommendedByLanguageUseCase

    @Binds
    abstract fun bindsGetLanguageListUseCase(getLanguageListUseCaseImpl: GetLanguageListUseCaseImpl): GetLanguageListUseCase

    @Binds
    abstract fun bindsGetYearListUseCase(getYearListUseCaseImpl: GetYearListUseCaseImpl): GetYearListUseCase

    @Binds
    abstract fun bindsMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MoviesRepository

    @Binds
    abstract fun bindsMoviesApi(movieApiImpl: MovieApiImpl): MovieApi

    @Binds
    abstract fun bindsLocalMovies(localMovieSourceImpl: LocalMovieSourceImpl): LocalMovieSource
}