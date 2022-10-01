package com.rappi.movie_module_api.data

interface MovieApi {
    suspend fun getUpcoming(): List<Movie>
    suspend fun getTopRated(): List<Movie>
    suspend fun getRecommended(language: String, year: String): List<Movie>
}