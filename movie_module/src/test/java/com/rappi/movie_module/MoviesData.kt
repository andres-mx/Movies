package com.rappi.movie_module

import com.rappi.movie_module_api.data.Movie

object MoviesData {
    const val YEAR = "2022"
    const val LANGUAGE = "EN"
    fun movies(): List<Movie> =
        listOf(
            Movie(movieId = "1", ""),
            Movie(movieId = "2", ""),
            Movie(movieId = "3", ""),
            Movie(movieId = "4", ""),
            Movie(movieId = "5", ""),
            Movie(movieId = "6", ""),
        )
}