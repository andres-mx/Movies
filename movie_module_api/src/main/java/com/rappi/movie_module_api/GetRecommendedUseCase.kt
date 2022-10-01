package com.rappi.movie_module_api

import com.rappi.movie_module_api.view_state.MovieState

interface GetRecommendedUseCase {
    suspend operator fun invoke(language: String, year: String): MovieState
}