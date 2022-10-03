package com.rappi.movie_module.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("upcoming")
    suspend fun getUpcoming(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = "cf689d1c71b97032eca0391929094623"
    ): MovieResponse

    @GET("top_rated")
    suspend fun getTopRated(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = "cf689d1c71b97032eca0391929094623"
    ): MovieResponse

    @GET("popular")
    suspend fun getRecommended(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = ""
    ): MovieResponse
}