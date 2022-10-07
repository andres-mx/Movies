package com.rappi.movie_module_api.data

interface LocalMovieSource {
    suspend fun getMovies(movieType: MovieType, limit: Int): List<Movie>
    suspend fun getMovieByYear(movieType: MovieType, limit: Int, year: String): List<Movie>
    suspend fun getMovieByLanguage(movieType: MovieType, limit: Int, language: String): List<Movie>
    suspend fun addMovies(movies: List<Movie>, type: MovieType)
    suspend fun deleteMovies()
}