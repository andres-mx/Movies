package com.rappi.detail_module.data

import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.database.MovieDetailDao
import com.rappi.detail_module_api.database.MovieDetailModel
import javax.inject.Inject

class LocalMovieDetailSourceImpl @Inject constructor(private val movieDetailDao: MovieDetailDao) :
    LocalMovieDetailSource {
    override suspend fun getMovieDetail(movieId: Int): MovieDetail? {
        val movieDetail = movieDetailDao.getMovieDetail(movieId)
        return if (movieDetail.movieId != null) {
            movieDetail.toMovieDetail()
        } else {
            null
        }
    }

    override suspend fun addMovieDetail(movieDetail: MovieDetail) {
        movieDetailDao.addMovieDetail(movieDetail.toMovieDetailModel())
    }

    override suspend fun deleteMoviesDetail() {
        movieDetailDao.deleteMoviesDetail()
    }
}

private fun MovieDetail.toMovieDetailModel(): MovieDetailModel = MovieDetailModel(
    movieId = this.movieId,
    imageUrl = this.imageUrl,
    year = this.year,
    language = this.language,
    title = this.title,
    originalTitle = this.originalTitle,
    description = this.description,
    rating = this.rating
)

private fun MovieDetailModel.toMovieDetail() = MovieDetail(
    movieId = this.movieId,
    imageUrl = this.imageUrl,
    year = this.year,
    language = this.language,
    title = this.title,
    originalTitle = this.originalTitle,
    description = this.description,
    rating = this.rating
)
