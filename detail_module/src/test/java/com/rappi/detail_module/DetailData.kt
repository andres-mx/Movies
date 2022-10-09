package com.rappi.detail_module

import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.database.MovieDetailModel

object DetailData {
    const val MOVIE_ID: Int = 70
    fun getDetailMovie(): MovieDetail =
        MovieDetail(
            movieId = 70,
            imageUrl = "",
            year = "2014",
            language = "EN",
            title = "HER",
            originalTitle = "HER",
            "Description"
        )

    fun getMovieDetailModel(): MovieDetailModel =
        MovieDetailModel(
            movieId = 70,
            imageUrl = "",
            year = "2014",
            language = "EN",
            title = "HER",
            originalTitle = "HER",
            "Description"
        )
}