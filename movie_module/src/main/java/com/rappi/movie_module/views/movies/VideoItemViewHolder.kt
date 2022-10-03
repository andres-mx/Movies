package com.rappi.movie_module.views.movies

import coil.load
import com.rappi.movie_module.databinding.VideoHolderBinding

class VideoItemViewHolder(private val videoHolderBinding: VideoHolderBinding) :
    VideoViewHolder(videoHolderBinding) {
    fun bind(videoSection: VideosData.VideosSection) = with(videoHolderBinding) {
        imageMovie.load(videoSection.videosViewData.urlImage) {
            crossfade(true)
            placeholder(android.R.drawable.btn_radio)
            error(android.R.drawable.stat_notify_error)
        }
    }
}