package com.rappi.movie_module.views.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rappi.movie_module.databinding.MovieHolderBinding
import com.rappi.movie_module.databinding.RecommendedHolderBinding

class MovieAdapter(
    private val listItemClick: (Int) -> Unit,
    private val filterItemClick: (Int) -> Unit
) :
    ListAdapter<MoviesData, VideoViewHolder>(COMPARATOR) {
    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<MoviesData>() {
            override fun areItemsTheSame(
                oldItem: MoviesData,
                newItem: MoviesData
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MoviesData,
                newItem: MoviesData
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder =
        when (viewType) {
            VideoViewType.VIDEO_SECTION.ordinal -> {
                MovieViewHolder(
                    MovieHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listItemClick
                )
            }
            else -> {
                RecommendedViewHolder(
                    RecommendedHolderBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    listItemClick,
                    filterItemClick
                )
            }
        }


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        when (val videoCurrentPosition = getItem(position)) {
            is MoviesData.MoviesSection -> {
                (holder as MovieViewHolder).bind(videoCurrentPosition)
            }
            is MoviesData.RecommendedSection -> {
                (holder as RecommendedViewHolder).bind(videoCurrentPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = when (getItem(position)) {
        is MoviesData.MoviesSection -> VideoViewType.VIDEO_SECTION.ordinal
        else -> VideoViewType.RECOMMENDED_SECTION.ordinal
    }
}