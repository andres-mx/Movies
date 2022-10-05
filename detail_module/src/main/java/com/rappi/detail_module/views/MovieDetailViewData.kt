package com.rappi.detail_module.views

data class MovieDetailViewData(
    val movieId: Int,
    val imageUrl: String,
    val year: String,
    val language: String,
    val title: String,
    val originalTitle: String,
    val description: String,
    val rating: String
)
