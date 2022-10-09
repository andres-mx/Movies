package com.rappi.detail_module.utils

import com.rappi.detail_module.BuildConfig
import com.rappi.detail_module.data.DetailMovieResponse
import com.rappi.detail_module.views.MovieDetailViewData
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.database.MovieDetailModel

object MovieDetailUtils {
    const val EMPTY_STRING = ""
    const val MOVIE_ID = "id"
    fun MovieDetail.toMovieDetailModel(): MovieDetailModel = MovieDetailModel(
        movieId = this.movieId,
        imageUrl = this.imageUrl,
        year = this.year,
        language = this.language,
        title = this.title,
        originalTitle = this.originalTitle,
        description = this.description,
        rating = this.rating
    )

    fun MovieDetailModel.toMovieDetail() = MovieDetail(
        movieId = this.movieId,
        imageUrl = this.imageUrl,
        year = this.year,
        language = this.language,
        title = this.title,
        originalTitle = this.originalTitle,
        description = this.description,
        rating = this.rating
    )

    fun DetailMovieResponse.toDetailMovie(): MovieDetail? = if (this.id == 0) {
        null
    } else {
        MovieDetail(
            movieId = this.id,
            imageUrl = this.poster_path.orEmpty(),
            year = this.release_date.orEmpty(),
            language = this.original_language.orEmpty(),
            title = this.title.orEmpty(),
            originalTitle = this.original_title.orEmpty(),
            description = this.overview.orEmpty(),
            rating = String.format("%.2f", vote_average)
        )
    }

    fun MovieDetail?.toMovieDetailViewData() = MovieDetailViewData(
        movieId = this?.movieId ?: 0,
        imageUrl = BuildConfig.URLIMAGES + this?.imageUrl.orEmpty(),
        year = this?.year?.toDateString().orEmpty(),
        language = this?.language.orEmpty(),
        title = this?.title.orEmpty(),
        originalTitle = this?.originalTitle.orEmpty(),
        description = this?.description.orEmpty(),
        rating = this?.rating.orEmpty()
    )

    private fun String.toDateString(): String = this.substring(0, 4)
}