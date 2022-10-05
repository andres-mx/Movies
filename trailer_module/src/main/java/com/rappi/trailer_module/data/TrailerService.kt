package com.rappi.trailer_module.data

import com.rappi.network_module_api.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrailerService {
    @GET("movie/{movie_id}/videos")
    suspend fun getTrailer(
        @Path("movie_id") movieId: Int = 1,
        @Query("api_key") apiKey: String? = BuildConfig.APIKEY
    ): TrailerResponse?
}