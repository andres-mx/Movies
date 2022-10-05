package com.rappi.movie_module.data

import com.rappi.network_module_api.BuildConfig.APIKEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieService {
    @GET("movie/upcoming")
    suspend fun getUpcoming(
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = APIKEY
    ): MovieResponse

    @GET("movie/top_rated")
    suspend fun getTopRated(
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = "cf689d1c71b97032eca0391929094623"
    ): MovieResponse

    @GET("movie/popular")
    suspend fun getRecommended(
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = APIKEY
    ): MovieResponse
}