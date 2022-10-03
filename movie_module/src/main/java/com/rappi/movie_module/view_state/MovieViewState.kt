package com.rappi.movie_module.view_state

import com.rappi.movie_module.views.movies.VideosData

sealed class MovieViewState {
    object Idle : MovieViewState()
    data class MoviesSuccessful(val movies: List<VideosData>) : MovieViewState()
    data class MoviesFailure(val error: String) : MovieViewState()
}