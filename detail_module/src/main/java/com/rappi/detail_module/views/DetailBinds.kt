package com.rappi.detail_module.views

import com.rappi.core_module.DetailMovieFromMovieRoute
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailBinds {
    @Binds
    abstract fun bindsDetailMovieFromMovie(detailMovieFromMovieRouteImpl: DetailMovieFromMovieRouteImpl): DetailMovieFromMovieRoute
}