package com.rappi.detail_module.di

import com.rappi.core_module.MovieDetailFromMovieRoute
import com.rappi.detail_module.data.LocalMovieDetailSourceImpl
import com.rappi.detail_module.data.MovieDetailApiImpl
import com.rappi.detail_module.domain.GetMovieDetailUseCaseImpl
import com.rappi.detail_module.repository.MovieDetailRepositoryImpl
import com.rappi.detail_module.views.MovieDetailFromMovieRouteImpl
import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.data.MovieDetailApi
import com.rappi.detail_module_api.domain.GetMovieDetailUseCase
import com.rappi.detail_module_api.repository.DetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailBinds {
    @Binds
    abstract fun bindsMovieDetailFromMovie(movieDetailFromMovieRouteImpl: MovieDetailFromMovieRouteImpl): MovieDetailFromMovieRoute

    @Binds
    abstract fun bindsMovieDetail(getMovieDetailUseCaseImpl: GetMovieDetailUseCaseImpl): GetMovieDetailUseCase

    @Binds
    abstract fun bindsMovieDetailRepository(movieDetailRepositoryImpl: MovieDetailRepositoryImpl): DetailRepository

    @Binds
    abstract fun bindsMovieDetailApi(movieDetailApiImpl: MovieDetailApiImpl): MovieDetailApi

    @Binds
    abstract fun bindsLocalMovieDetail(localMovieDetailSourceImpl: LocalMovieDetailSourceImpl): LocalMovieDetailSource
}