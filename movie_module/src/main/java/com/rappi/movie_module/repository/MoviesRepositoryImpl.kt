package com.rappi.movie_module.repository

import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieApi
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(private val movieApi: MovieApi) : MoviesRepository {
    override suspend fun getUpcoming(): List<Movie> = movieApi.getUpcoming()

    override suspend fun getTopRated(): List<Movie> = movieApi.getTopRated()

    override suspend fun getRecommended(): List<Movie> = movieApi.getRecommended()
}