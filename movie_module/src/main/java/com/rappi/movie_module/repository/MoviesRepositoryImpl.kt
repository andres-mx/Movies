package com.rappi.movie_module.repository

import com.rappi.movie_module_api.data.LocalMovieSource
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieApi
import com.rappi.movie_module_api.data.MovieType
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val localMovieSource: LocalMovieSource
) : MoviesRepository {
    override suspend fun getUpcoming(): List<Movie> = try {
        val movies = movieApi.getUpcoming()
        localMovieSource.addMovies(movies, MovieType.UPCOMING)
        movies
    } catch (ex: Exception) {
        localMovieSource.getMovies(MovieType.UPCOMING, 19).ifEmpty {
            emptyList()
        }
    }

    override suspend fun getTopRated(): List<Movie> = try {
        val movies = movieApi.getTopRated()
        localMovieSource.addMovies(movies, MovieType.TOP_RATED)
        movies
    } catch (ex: Exception) {
        localMovieSource.getMovies(MovieType.TOP_RATED, 19).ifEmpty {
            emptyList()
        }
    }

    override suspend fun getRecommended(): List<Movie> = try {
        val movies = movieApi.getRecommended()
        localMovieSource.addMovies(movies, MovieType.RECOMMENDED)
        movies
    } catch (ex: Exception) {
        localMovieSource.getMovies(MovieType.RECOMMENDED, 6).ifEmpty {
            emptyList()
        }
    }
}