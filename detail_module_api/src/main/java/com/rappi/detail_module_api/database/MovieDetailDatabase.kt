package com.rappi.detail_module_api.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieDetailModel::class], version = 1)
abstract class MovieDetailDatabase : RoomDatabase() {
    abstract fun getMovieDetailDao(): MovieDetailDao
}