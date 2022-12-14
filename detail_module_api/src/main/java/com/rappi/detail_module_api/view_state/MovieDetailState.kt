package com.rappi.detail_module_api.view_state

import androidx.annotation.StringRes
import com.rappi.detail_module_api.data.MovieDetail

sealed class MovieDetailState {
    object Idle : MovieDetailState()
    data class MovieDetailSuccessful(val movieDetail: MovieDetail) : MovieDetailState()
    object MovieDetailEmpty : MovieDetailState()
    data class MovieDetailFailure(@StringRes val error: Int) : MovieDetailState()
}
