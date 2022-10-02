package com.rappi.movie_module

import com.rappi.movie_module.data.MovieResponse
import com.rappi.movie_module.data.Result
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.view_state.MovieState
import com.rappi.movie_module_api.view_state.MovieState.UpComingSuccessful

object MoviesData {
    const val YEAR = "2022"
    const val LANGUAGE = "EN"
    fun movies(): List<Movie> =
        listOf(
            Movie(movieId = 1, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Movie(movieId = 2, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Movie(movieId = 3, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Movie(movieId = 4, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Movie(movieId = 5, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
            Movie(movieId = 6, "/wSqAXL1EHVJ3MOnJzMhUngc8gFs.jpg"),
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
        return UpComingSuccessful(movies())
    }
}