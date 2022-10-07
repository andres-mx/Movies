package com.rappi.movie_module_api.repository

import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieType

interface MoviesRepository {
    suspend fun getUpcoming(): List<Movie>
    suspend fun getTopRated(): List<Movie>
    suspend fun getRecommended(): List<Movie>
    suspend fun getMovieByYear(movieType: MovieType, year: String): List<Movie>
    suspend fun getLanguages(): List<String>
    suspend fun getYear(): List<String>
}