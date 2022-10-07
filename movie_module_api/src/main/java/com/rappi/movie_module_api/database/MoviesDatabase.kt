package com.rappi.movie_module_api.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieModel::class], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}