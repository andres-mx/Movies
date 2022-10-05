package com.rappi.movie_module.views.movies

import coil.load
import com.rappi.core_module.R
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
                placeholder(R.mipmap.ic_launcher)
                error(R.mipmap.ic_launcher)
            }
            setOnClickListener {
                listItemClick(video.id)
            }
        }
    }
}