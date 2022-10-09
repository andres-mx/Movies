package com.rappi.detail_module.data

import com.rappi.detail_module.utils.MovieDetailUtils.toMovieDetail
import com.rappi.detail_module.utils.MovieDetailUtils.toMovieDetailModel
import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.database.MovieDetailDao
import javax.inject.Inject

class LocalMovieDetailSourceImpl @Inject constructor(private val movieDetailDao: MovieDetailDao) :
    LocalMovieDetailSource {
    override suspend fun getMovieDetail(movieId: Int): MovieDetail? {
        return movieDetailDao.getMovieDetail(movieId)?.toMovieDetail()
    }

    override suspend fun addMovieDetail(movieDetail: MovieDetail) {
        movieDetailDao.addMovieDetail(movieDetail.toMovieDetailModel())
    }

    override suspend fun deleteMoviesDetail() {
        movieDetailDao.deleteMoviesDetail()
    }
}
