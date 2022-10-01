package com.rappi.movie_module.repository

import com.rappi.movie_module_api.MoviesRepository
import com.rappi.movie_module_api.data.Movie
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor() : MoviesRepository {
    override fun getUpcoming(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getTopRated(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getRecommended(language: Any, year: Any): List<Movie> {
        TODO("Not yet implemented")
    }
}