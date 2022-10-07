package com.rappi.detail_module_api.repository

import com.rappi.detail_module_api.data.MovieDetail

interface DetailRepository {
    suspend fun getDetailMovie(movieId: Int): MovieDetail?
}