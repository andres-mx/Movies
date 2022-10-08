package com.rappi.movie_module.view_models

import com.rappi.movie_module_api.data.Movie

data class MoviesDataToConvert(
    val upComings: List<Movie>,
    val topRatedList: List<Movie>,
    val recommendedList: List<Movie>,
    val language: String = "",
    val year: String = ""
)
