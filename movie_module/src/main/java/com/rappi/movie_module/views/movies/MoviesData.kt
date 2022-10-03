package com.rappi.movie_module.views.movies

sealed class MoviesData {
    data class MoviesSection(val movieViewData: MovieViewData) : MoviesData()
}
