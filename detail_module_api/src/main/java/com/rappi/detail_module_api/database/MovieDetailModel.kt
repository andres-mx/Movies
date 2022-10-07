package com.rappi.detail_module_api.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_detail_table")
data class MovieDetailModel(
    @PrimaryKey
    val movieId: Int?,
    val imageUrl: String,
    val year: String,
    val language: String,
    val title: String,
    val originalTitle: String,
    val description: String,
    val rating: String? = "0.0"
)
