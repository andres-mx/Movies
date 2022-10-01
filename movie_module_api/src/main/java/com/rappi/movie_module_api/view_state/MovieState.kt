package com.rappi.movie_module_api.view_state

import androidx.annotation.StringRes
import com.rappi.movie_module_api.data.Movie

sealed class MovieState {
    object Idle : MovieState()
    data class UpComingSuccessful(val movies: List<Movie>) : MovieState()
    object UpComingEmpty : MovieState()
    data class TopRatedSuccessful(val movies: List<Movie>) : MovieState()
    object TopRatedEmpty : MovieState()
    data class RecommendedSuccessful(val movies: List<Movie>) : MovieState()
    object RecommendedEmpty : MovieState()
    data class UpComingFailure(@StringRes val error: Int) : MovieState()
    data class TopRatedFailure(@StringRes val error: Int) : MovieState()
    data class RecommendedFailure(@StringRes val error: Int) : MovieState()
}
