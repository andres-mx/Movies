package com.rappi.detail_module.data

import com.rappi.detail_module.utils.MovieDetailUtils.toDetailMovie
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.data.MovieDetailApi
import javax.inject.Inject

class MovieDetailApiImpl @Inject constructor(private val movieDetailService: MovieDetailService) :
    MovieDetailApi {
    override suspend fun getDetailMovie(id: Int): MovieDetail? {
        val detailResponse = movieDetailService.getMovieDetail(movieId = id)
        return detailResponse?.toDetailMovie()
    }
}

