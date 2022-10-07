package com.rappi.movie_module_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movie_table WHERE type = :movieType LIMIT :limit")
    suspend fun getMovies(movieType: String, limit: Int): List<MovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<MovieModel>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()
}