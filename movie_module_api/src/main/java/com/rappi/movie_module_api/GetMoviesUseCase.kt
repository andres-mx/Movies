package com.rappi.movie_module_api

import com.rappi.movie_module_api.view_state.MovieState

interface GetMoviesUseCase {
    suspend operator fun invoke(): MovieState
}