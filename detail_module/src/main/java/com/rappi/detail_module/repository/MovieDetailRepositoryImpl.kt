package com.rappi.detail_module.repository

import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.data.MovieDetailApi
import com.rappi.detail_module_api.repository.DetailRepository
import javax.inject.Inject

class MovieDetailRepositoryImpl @Inject constructor(
    private val movieDetailApi: MovieDetailApi,
    private val localMovieDetailSource: LocalMovieDetailSource
) :
    DetailRepository {
    override suspend fun getDetailMovie(movieId: Int): MovieDetail? = try {
        val movieDetail = movieDetailApi.getDetailMovie(movieId)
        if (movieDetail != null) {
            localMovieDetailSource.addMovieDetail(movieDetail)
        }
        movieDetail
    } catch (ex: Exception) {
        localMovieDetailSource.getMovieDetail(movieId)
    }
}