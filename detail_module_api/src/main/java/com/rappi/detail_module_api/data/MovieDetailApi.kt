package com.rappi.detail_module_api.data

interface MovieDetailApi {
    suspend fun getDetailMovie(id: Int): MovieDetail?
}