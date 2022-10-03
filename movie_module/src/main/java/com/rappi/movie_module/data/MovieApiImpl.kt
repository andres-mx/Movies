package com.rappi.movie_module.data

import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieApi
import com.rappi.network_module_api.NetworkOkHttpClient
import com.rappi.network_module_api.NetworkRetrofit
import retrofit2.Retrofit
import javax.inject.Inject

class MovieApiImpl @Inject constructor(@NetworkRetrofit retrofit: Retrofit) : MovieApi {
    private val movieService = retrofit.create(MovieService::class.java)

    override suspend fun getUpcoming(): List<Movie> =
        movieService.getUpcoming().results?.map { it.toMovie() } ?: emptyList()

    override suspend fun getTopRated(): List<Movie> =
        movieService.getTopRated().results?.map { it.toMovie() } ?: emptyList()

    override suspend fun getRecommended(language: String, year: String): List<Movie> =
        movieService.getRecommended().results?.map { it.toMovie() } ?: emptyList()
}

private fun Result.toMovie(): Movie =
    Movie(movieId = this.id ?: 0, image = this.poster_path.orEmpty())

private fun Result.toMovie(language: String, year: String): Movie =
    Movie(movieId = this.id ?: 0, image = this.poster_path.orEmpty())