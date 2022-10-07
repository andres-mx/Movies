package com.rappi.detail_module

import com.rappi.detail_module_api.data.MovieDetail

object DetailData {
    fun getDetailMovie(): MovieDetail =
        MovieDetail(
            movieId = 1,
            imageUrl = "",
            year = "2014",
            language = "EN",
            title = "HER",
            originalTitle = "HER",
            "Description"
        )
}