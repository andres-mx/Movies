package com.rappi.trailer_module.data

import com.rappi.network_module_api.BuildConfig
import com.rappi.trailer_module_api.data.Trailer
import com.rappi.trailer_module_api.data.TrailerApi
import javax.inject.Inject

class TrailerApiImpl @Inject constructor(private val trailerService: TrailerService) : TrailerApi {
    override suspend fun getTrailer(id: Int): Trailer? {
        val trailerResponse = trailerService.getTrailer(id)
        return trailerResponse.toTrailer()
    }
}

private fun TrailerResponse?.toTrailer(): Trailer? = if (this?.id == 0) {
    null
} else {
    Trailer(
        movieId = this?.id,
        trailerUrl = "https://www.youtube.com/watch?v=" + this?.results?.firstOrNull()?.key
    )
}