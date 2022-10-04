package com.rappi.detail_module.view_state

import com.rappi.detail_module.views.MovieDetailViewData

sealed class MovieDetailViewState {
    object Idle : MovieDetailViewState()
    data class MovieDetailSuccessful(val movieDetailViewData: MovieDetailViewData) : MovieDetailViewState()
    data class MovieDetailFailure(val error: String) : MovieDetailViewState()
}
