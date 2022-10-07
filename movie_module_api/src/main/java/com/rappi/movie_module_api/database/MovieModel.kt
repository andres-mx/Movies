package com.rappi.movie_module_api.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieModel(
    @PrimaryKey
    val movieId: Int,
    val image: String,
    val language: String,
    val year: String,
    val type: String
)
