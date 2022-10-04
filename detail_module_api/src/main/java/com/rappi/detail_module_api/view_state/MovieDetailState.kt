package com.rappi.detail_module_api.view_state

import androidx.annotation.StringRes

sealed class MovieDetailState {
    object Idle : MovieDetailState()
    data class MovieDetailSuccessful(val any: Any) : MovieDetailState()
    data class UpComingFailure(@StringRes val error: Int) : MovieDetailState()
}
