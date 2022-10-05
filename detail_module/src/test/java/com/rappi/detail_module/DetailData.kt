package com.rappi.detail_module

import com.rappi.detail_module_api.data.DetailMovie

object DetailData {
    fun getDetailMovie(): DetailMovie =
        DetailMovie(
            movieId = 1,
            imageUrl = "",
            year = "2014",
            language = "EN",
            title = "HER",
            originalTitle = "HER",
            "Description"
        )
}