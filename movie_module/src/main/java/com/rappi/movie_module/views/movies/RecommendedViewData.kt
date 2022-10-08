package com.rappi.movie_module.views.movies

data class RecommendedViewData(
    val filterOptions: HashMap<Int, String>,
    val videos: List<VideosViewData>
)
