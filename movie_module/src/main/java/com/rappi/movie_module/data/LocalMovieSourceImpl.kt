package com.rappi.movie_module.data

import com.rappi.movie_module_api.data.LocalMovieSource
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.database.MovieModel
import com.rappi.movie_module_api.database.MoviesDao
import javax.inject.Inject

class LocalMovieSourceImpl @Inject constructor(private val moviesDao: MoviesDao) :
    LocalMovieSource {
    override suspend fun getMovies(movieType: MovieType, limit: Int): List<Movie> {
        val moviesDatabase = moviesDao.getMovies(movieType.name, limit)
        val movies = mutableListOf<Movie>()
        moviesDatabase.map { movieData ->
            movies.add(movieData.toMovie())
        }
        return movies
    }

    override suspend fun getMovieByYear(
        movieType: MovieType,
        limit: Int,
        year: String
    ): List<Movie> {
        val moviesDatabase = moviesDao.getMoviesByYear(movieType.name, limit, year)
        val movies = mutableListOf<Movie>()
        moviesDatabase.map { movieData ->
            movies.add(movieData.toMovie())
        }
        return movies
    }

    override suspend fun getMovieByLanguage(
        movieType: MovieType,
        limit: Int,
        language: String
    ): List<Movie> {
        val moviesDatabase =
            moviesDao.getMoviesByLanguage(movieType.name, limit, language)
        val movies = mutableListOf<Movie>()
        println("movies: "+moviesDatabase.size.toString())
        moviesDatabase.map { movieData ->
            movies.add(movieData.toMovie())
        }
        return movies
    }

    override suspend fun addMovies(movies: List<Movie>, type: MovieType) {
        val moviesDatabase = mutableListOf<MovieModel>()
        movies.map { movie ->
            moviesDatabase.add(movie.toMovieModel(type))
        }
        moviesDao.addMovies(moviesDatabase)
    }

    override suspend fun deleteMovies() {
        moviesDao.deleteMovies()
    }
}

private fun Movie.toMovieModel(type: MovieType) = MovieModel(
    movieId = this.movieId,
    image = this.image,
    language = this.language.orEmpty(),
    year = this.year.orEmpty(),
    type = type.name
)

private fun MovieModel.toMovie() = Movie(
    movieId = this.movieId,
    image = this.image,
    language = this.language,
    year = this.year,
    type = this.type
)
