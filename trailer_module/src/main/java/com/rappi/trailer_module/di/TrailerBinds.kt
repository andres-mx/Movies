package com.rappi.trailer_module.di

import com.rappi.core_module.TrailerFromMovieDetailRoute
import com.rappi.trailer_module.data.TrailerApiImpl
import com.rappi.trailer_module.domain.GetTrailerUseCaseImpl
import com.rappi.trailer_module.repository.TrailerRepositoryImpl
import com.rappi.trailer_module.views.TrailerFromMovieDetailRouteImpl
import com.rappi.trailer_module_api.data.TrailerApi
import com.rappi.trailer_module_api.domain.GetTrailerUseCase
import com.rappi.trailer_module_api.repository.TrailerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class TrailerBinds {
    @Binds
    abstract fun bindsTrailerFromDetailMovie(trailerFromMovieDetailRouteImpl: TrailerFromMovieDetailRouteImpl): TrailerFromMovieDetailRoute

    @Binds
    abstract fun bindsTrailerDetail(getTrailerUseCaseImpl: GetTrailerUseCaseImpl): GetTrailerUseCase

    @Binds
    abstract fun bindsTrailerRepository(trailerRepositoryImpl: TrailerRepositoryImpl): TrailerRepository

    @Binds
    abstract fun bindsTrailerApi(trailerApiImpl: TrailerApiImpl): TrailerApi
}