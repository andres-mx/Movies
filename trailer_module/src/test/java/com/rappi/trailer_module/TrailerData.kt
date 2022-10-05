package com.rappi.trailer_module

import com.rappi.trailer_module_api.data.Trailer

object TrailerData {
    fun getTrailer(): Trailer = Trailer(
        movieId = 1,
        trailerUrl = ""
    )
}