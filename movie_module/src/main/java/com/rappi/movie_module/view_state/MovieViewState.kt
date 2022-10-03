package com.rappi.movie_module.view_state

import com.rappi.movie_module.views.movies.MoviesData

sealed class MovieViewState {
    object Idle : MovieViewState()
    data class MoviesSuccessful(val movies: List<MoviesData>) : MovieViewState()
    data class MoviesFailure(val error: String) : MovieViewState()
}