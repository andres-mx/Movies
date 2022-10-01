package com.rappi.movie_module.data

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("/movie/upcoming")
    suspend fun getUpcoming(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = ""
    ): MovieResponse

    @GET("/movie/top_rated")
    suspend fun getTopRated(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = ""
    ): MovieResponse

    @GET("/movie/popular")
    suspend fun getRecommended(
        @Query("language") language: String? = "",
        @Query("page") page: String? = "1",
        @Query("api_key") apiKey: String? = ""
    ): MovieResponse
}