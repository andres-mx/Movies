package com.rappi.movie_module.views.movies

import coil.load
import com.rappi.movie_module.databinding.VideoHolderBinding

class VideoItemViewHolder(
    private val videoHolderBinding: VideoHolderBinding,
    private val listItemClick: (Int) -> Unit
) :
    VideoViewHolder(videoHolderBinding) {
    fun bind(video: VideosViewData) = with(videoHolderBinding) {
        imageMovie.apply {
            this.load(video.urlImage) {
                crossfade(true)
                placeholder(android.R.drawable.btn_radio)
                error(android.R.drawable.stat_notify_error)
            }
            setOnClickListener {
                listItemClick(video.id)
            }
        }
    }
}