package com.rappi.detail_module_api.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDetailDao {
    @Query("SELECT * FROM movie_detail_table WHERE movieId = :movieId")
    suspend fun getMovieDetail(movieId: Int): MovieDetailModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieDetail(movieDetail: MovieDetailModel)

    @Query("DELETE FROM movie_detail_table")
    suspend fun deleteMoviesDetail()
}