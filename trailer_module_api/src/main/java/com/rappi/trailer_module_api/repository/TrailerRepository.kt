package com.rappi.trailer_module_api.repository

import com.rappi.trailer_module_api.data.Trailer

interface TrailerRepository {
    suspend fun getTrailer(movieId: Int): Trailer?
}