package com.rappi.movie_module.view_state

sealed class MovieViewState {
    object Idle : MovieViewState()
    data class MoviesSuccessful(val movies: Any) : MovieViewState()
    data class MoviesFailure(val error: String) : MovieViewState()
}