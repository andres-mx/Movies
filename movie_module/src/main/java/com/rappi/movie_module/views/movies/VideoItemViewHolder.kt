package com.rappi.movie_module.views.movies

import coil.load
import com.rappi.movie_module.databinding.VideoHolderBinding

class VideoItemViewHolder(private val videoHolderBinding: VideoHolderBinding) :
    VideoViewHolder(videoHolderBinding) {
    fun bind(video: VideosViewData) = with(videoHolderBinding) {
        imageMovie.load(video.urlImage) {
            crossfade(true)
            placeholder(android.R.drawable.btn_radio)
            error(android.R.drawable.stat_notify_error)
        }
    }
}