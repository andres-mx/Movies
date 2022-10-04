package com.rappi.detail_module_api

import com.rappi.detail_module_api.view_state.MovieDetailState

interface GetDetailMoviesUseCase {
    suspend operator fun invoke(): MovieDetailState
}