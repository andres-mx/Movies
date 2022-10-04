package com.rappi.movie_module_api.repository

import com.rappi.movie_module_api.data.Movie

interface MoviesRepository {
    suspend fun getUpcoming(): List<Movie>
    suspend fun getTopRated(): List<Movie>
    suspend fun getRecommended(language: String, year: String): List<Movie>
}