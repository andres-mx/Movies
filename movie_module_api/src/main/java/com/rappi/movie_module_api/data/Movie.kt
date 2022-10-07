package com.rappi.movie_module_api.data

data class Movie(
    val movieId: Int,
    val image: String,
    val language: String? = "",
    val year: String? = "",
    val type: String? = ""
)
