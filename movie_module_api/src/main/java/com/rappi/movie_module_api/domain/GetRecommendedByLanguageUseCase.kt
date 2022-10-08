package com.rappi.movie_module_api.domain

import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.view_state.MovieState

interface GetRecommendedByLanguageUseCase {
    suspend operator fun invoke(movieType: MovieType, language: String): MovieState
}