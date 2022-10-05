package com.rappi.trailer_module_api.data

interface TrailerApi {
    suspend fun getTrailer(id: Int): Trailer?
}