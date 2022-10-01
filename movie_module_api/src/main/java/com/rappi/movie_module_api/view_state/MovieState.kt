package com.rappi.movie_module_api.view_state

import androidx.annotation.StringRes
import com.rappi.movie_module_api.data.Movie

sealed class MovieState {
    object Idle : MovieState()
    data class UpComingSuccessful(val movies: List<Movie>) : MovieState()
    object UpComingEmpty : MovieState()
    data class MovieFailure(@StringRes val error: Int) : MovieState()
}
