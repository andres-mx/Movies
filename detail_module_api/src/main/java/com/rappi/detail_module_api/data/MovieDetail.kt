package com.rappi.detail_module_api.data

data class MovieDetail(
    val movieId: Int?,
    val imageUrl: String,
    val year: String,
    val language: String,
    val title: String,
    val originalTitle: String,
    val description: String,
    val rating: String? = "0.0"
)
