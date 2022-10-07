package com.rappi.movie_module_api.data

interface LocalMovieSource {
    suspend fun getMovies(movieType: MovieType): List<Movie>
    suspend fun addMovies(movies: List<Movie>, type: MovieType)
    suspend fun deleteMovies()
}