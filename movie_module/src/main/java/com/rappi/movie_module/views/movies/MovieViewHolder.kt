package com.rappi.movie_module.views.movies

import com.rappi.movie_module.databinding.MovieHolderBinding

class MovieViewHolder(
    private val movieHolderBinding: MovieHolderBinding,
    private val listItemClick: (Int) -> Unit
) :
    VideoViewHolder(movieHolderBinding) {
    private lateinit var videoAdapter: VideoAdapter
    fun bind(videoSection: MoviesData.MoviesSection) = with(movieHolderBinding) {
        titleSection.text = videoSection.movieViewData.title
        videoAdapter = VideoAdapter(videoSection.movieViewData.videos, listItemClick)
        videos.adapter = videoAdapter
    }
}