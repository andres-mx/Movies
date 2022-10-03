package com.rappi.movie_module.views.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rappi.movie_module.databinding.MovieHolderBinding

class MovieAdapter(
    private val moviesData: List<MoviesData>,
    private val listItemClick: (Int) -> Unit
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
        MovieViewHolder(
            MovieHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listItemClick
        )


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        when (val videoCurrentPosition = moviesData[position]) {
            is MoviesData.MoviesSection -> {
                (holder as MovieViewHolder).bind(videoCurrentPosition)
            }
        }
    }

    override fun getItemViewType(position: Int): Int = VideoViewType.VIDEO_SECTION.ordinal

    override fun getItemCount(): Int = moviesData.size
}