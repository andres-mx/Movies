package com.rappi.trailer_module_api.domain

import com.rappi.trailer_module_api.view_state.TrailerState

interface GetTrailerUseCase {
    suspend operator fun invoke(movieId: Int): TrailerState
}