package com.rappi.detail_module_api.data

interface LocalMovieDetailSource {
    suspend fun getMovieDetail(movieId: Int): MovieDetail?
    suspend fun addMovieDetail(movieDetail: MovieDetail)
    suspend fun deleteMoviesDetail()
}