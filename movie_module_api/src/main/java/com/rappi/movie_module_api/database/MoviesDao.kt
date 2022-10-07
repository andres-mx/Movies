package com.rappi.movie_module_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movie_table WHERE type = :movieType LIMIT :limit")
    suspend fun getMovies(movieType: String, limit: Int): List<MovieModel>

    @Query("SELECT * FROM movie_table WHERE type = :movieType AND :year=year LIMIT :limit")
    suspend fun getMoviesByYear(movieType: String, limit: Int, year: String): List<MovieModel>

    @Query("SELECT * FROM movie_table WHERE type = :movieType AND language=language LIMIT :limit")
    suspend fun getMoviesByLanguage(
        movieType: String, limit: Int, language: String
    ): List<MovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<MovieModel>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteMovies()
}