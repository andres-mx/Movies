package com.rappi.movie_module.views.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rappi.movie_module.databinding.HeaderHolderBinding
import com.rappi.movie_module.databinding.VideoHolderBinding

class VideoAdapter(private val videosData: List<VideosData>) :
    RecyclerView.Adapter<VideoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder =
        when (viewType) {
            VideoViewType.HEADER_SECTION.ordinal -> {
                HeaderViewHolder(
                    HeaderHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                VideoItemViewHolder(
                    VideoHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        when (val videoCurrentPosition = videosData[position]) {
            is VideosData.HeaderSection -> {
                (holder as HeaderViewHolder).bind(videoCurrentPosition)
            }
            is VideosData.VideosSection -> {
                (holder as VideoItemViewHolder).bind(videoCurrentPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (videosData[position]) {
        is VideosData.HeaderSection -> VideoViewType.HEADER_SECTION.ordinal
        else -> VideoViewType.VIDEO_SECTION.ordinal
    }

    override fun getItemCount(): Int = videosData.size
}