package com.rappi.detail_module_api.domain

import com.rappi.detail_module_api.view_state.MovieDetailState

interface GetMovieDetailUseCase {
    suspend operator fun invoke(movieId: Int): MovieDetailState
}