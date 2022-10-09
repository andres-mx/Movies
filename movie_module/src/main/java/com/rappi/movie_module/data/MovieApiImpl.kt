package com.rappi.movie_module.data

import com.rappi.movie_module.utils.MovieUtils.toMovie
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieApi
import javax.inject.Inject

class MovieApiImpl @Inject constructor(private val movieService: MovieService) : MovieApi {
    override suspend fun getUpcoming(): List<Movie> =
        movieService.getUpcoming().results?.map { it.toMovie() } ?: emptyList()

    override suspend fun getTopRated(): List<Movie> =
        movieService.getTopRated().results?.map { it.toMovie() } ?: emptyList()

    override suspend fun getRecommended(): List<Movie> =
        movieService.getRecommended().results?.map { it.toMovie() } ?: emptyList()
}