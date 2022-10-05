package com.rappi.trailer_module.domain

import com.rappi.trailer_module.R
import com.rappi.trailer_module_api.domain.GetTrailerUseCase
import com.rappi.trailer_module_api.repository.TrailerRepository
import com.rappi.trailer_module_api.view_state.TrailerState
import javax.inject.Inject

class GetTrailerUseCaseImpl @Inject constructor(private val trailerRepository: TrailerRepository) :
    GetTrailerUseCase {
    override suspend fun invoke(movieId: Int): TrailerState {
        return try {
            val trailer = trailerRepository.getTrailer(movieId)
            if (trailer == null) {
                TrailerState.TrailerEmpty
            } else {
                TrailerState.TrailerSuccessful(trailer)
            }
        } catch (e: Exception) {
            TrailerState.TrailerFailure(R.string.trailer_error)
        }
    }
}