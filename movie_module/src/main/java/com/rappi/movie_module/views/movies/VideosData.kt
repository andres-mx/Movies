package com.rappi.movie_module.views.movies

sealed class VideosData {
    data class HeaderSection(val headerViewData: HeaderViewData) : VideosData()
    data class VideosSection(val videosViewData: VideosViewData) : VideosData()
}
