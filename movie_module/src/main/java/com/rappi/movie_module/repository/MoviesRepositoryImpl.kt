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
        movies.take(6)
    } catch (ex: Exception) {
        localMovieSource.getMovies(MovieType.RECOMMENDED, 6).ifEmpty {
            emptyList()
        }
    }

    override suspend fun getMovieByLanguage(movieType: MovieType, language: String): List<Movie> =
        try {
            localMovieSource.getMovieByLanguage(movieType, 6, language.lowercase())
        } catch (ex: Exception) {
            emptyList()
        }

    override suspend fun getMovieByYear(movieType: MovieType, year: String): List<Movie> = try {
        localMovieSource.getMovieByYear(movieType, 6, year)
    } catch (ex: Exception) {
        emptyList()
    }

    override suspend fun getLanguages(): List<String> = try {
        val languages = localMovieSource.getMovies(MovieType.RECOMMENDED, 19)
        val languageList = mutableListOf<String>()
        languages.map { movie ->
            if (movie.language?.isNotEmpty() == true) {
                languageList.add(movie.language.orEmpty())
            }
        }
        languageList.toSet().toList()
    } catch (ex: Exception) {
        emptyList()
    }

    override suspend fun getYear(): List<String> = try {
        val years = localMovieSource.getMovies(MovieType.RECOMMENDED, 19)
        val yearList = mutableListOf<String>()
        years.map { movie ->
            if (movie.year?.isNotEmpty() == true) {
                yearList.add(movie.year.orEmpty())
            }
        }
        yearList.toSet().toList()
    } catch (ex: Exception) {
        emptyList()
    }
}