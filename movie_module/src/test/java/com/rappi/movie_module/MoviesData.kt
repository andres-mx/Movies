package com.rappi.movie_module

import com.rappi.movie_module.data.MovieResponse
import com.rappi.movie_module.data.Result
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.database.MovieModel
import com.rappi.movie_module_api.view_state.MovieState
import com.rappi.movie_module_api.view_state.MovieState.UpComingSuccessful

object MoviesData {
    const val YEAR = "2022"
    const val LANGUAGE = "EN"
    const val LIMIT = 6
    fun upcomingMovies(): List<Movie> =
        listOf(
            Movie(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            Movie(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            Movie(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "UPCOMING"
            ),
            Movie(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "UPCOMING"
            ),
            Movie(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "fr",
                year = "2022",
                type = "UPCOMING"
            ),
            Movie(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "it",
                year = "2020",
                type = "UPCOMING"
            ),
        )

    fun topRatedMovies(): List<Movie> =
        listOf(
            Movie(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            Movie(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            Movie(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "TOP_RATED"
            ),
            Movie(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "TOP_RATED"
            ),
            Movie(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "fr",
                year = "2022",
                type = "TOP_RATED"
            ),
            Movie(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "it",
                year = "2022",
                type = "TOP_RATED"
            ),
        )

    fun recommendedMovies(): List<Movie> =
        listOf(
            Movie(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            Movie(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            Movie(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            Movie(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            Movie(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "fr",
                year = "2022",
                type = "RECOMMENDED"
            ),
            Movie(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "it",
                year = "2022",
                type = "RECOMMENDED"
            ),
        )

    fun upcomingMoviesModel(): List<MovieModel> =
        listOf(
            MovieModel(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            MovieModel(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            MovieModel(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            MovieModel(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            MovieModel(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
            MovieModel(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "UPCOMING"
            ),
        )

    fun topRatedMoviesModel(): List<MovieModel> =
        listOf(
            MovieModel(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            MovieModel(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            MovieModel(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            MovieModel(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            MovieModel(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
            MovieModel(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "TOP_RATED"
            ),
        )

    fun recommendedMoviesModel(): List<MovieModel> =
        listOf(
            MovieModel(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 6,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "it",
                year = "2020",
                type = "RECOMMENDED"
            ),
        )

    fun recommendedByYearMoviesModel(): List<MovieModel> =
        listOf(
            MovieModel(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 3,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 4,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "es",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            )
        )

    fun recommendedByLanguageMoviesModel(): List<MovieModel> =
        listOf(
            MovieModel(
                movieId = 1,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 2,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            ),
            MovieModel(
                movieId = 5,
                image = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg",
                language = "en",
                year = "2022",
                type = "RECOMMENDED"
            )
        )

    fun moviesResponse(): MovieResponse = MovieResponse(
        page = 1,
        results = listOf(
            Result(id = 1, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Result(id = 2, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Result(id = 3, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Result(id = 4, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Result(id = 5, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Result(id = 6, poster_path = "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg")
        ),
        total_pages = 1,
        total_results = 1
    )

    fun moviesState(): MovieState {
        return UpComingSuccessful(upcomingMovies())
    }
}