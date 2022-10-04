package com.rappi.detail_module.data

import com.rappi.network_module_api.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {
    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: Int = 1,
        @Query("api_key") apiKey: String? = BuildConfig.APIKEY
    ): DetailMovieResponse?
}