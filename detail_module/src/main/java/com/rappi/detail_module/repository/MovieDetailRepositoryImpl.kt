package com.rappi.detail_module.repository

import com.rappi.detail_module_api.data.DetailMovie
import com.rappi.detail_module_api.data.MovieDetailApi
import com.rappi.detail_module_api.repository.DetailRepository
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(private val movieDetailApi: MovieDetailApi) :
    DetailRepository {
    override suspend fun getDetailMovie(movieId: Int): DetailMovie? =
        movieDetailApi.getDetailMovie(movieId)

}