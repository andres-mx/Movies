package com.rappi.movie_module_api

import com.rappi.movie_module_api.data.Movie

interface MoviesRepository {
    fun getUpcoming(): List<Movie>
    fun getTopRated(): List<Movie>
    fun getRecommended(language: String, year: String): List<Movie>
}