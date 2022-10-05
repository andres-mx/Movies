package com.rappi.trailer_module.repository

import com.rappi.trailer_module_api.data.Trailer
import com.rappi.trailer_module_api.data.TrailerApi
import com.rappi.trailer_module_api.repository.TrailerRepository
import javax.inject.Inject

class TrailerRepositoryImpl @Inject constructor(private val trailerApi: TrailerApi) :
    TrailerRepository {
    override suspend fun getTrailer(movieId: Int): Trailer? = trailerApi.getTrailer(movieId)
}