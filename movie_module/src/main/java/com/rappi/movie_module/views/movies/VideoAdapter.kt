package com.rappi.movie_module.views.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rappi.movie_module.databinding.VideoHolderBinding

class VideoAdapter(
    private val videos: List<VideosViewData>,
    private val listItemClick: (Int) -> Unit
) :
    RecyclerView.Adapter<VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder =
        VideoItemViewHolder(
            VideoHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), listItemClick
        )

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        (holder as VideoItemViewHolder).bind(videos[position])
    }

    override fun getItemCount(): Int = videos.size
}