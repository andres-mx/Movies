package com.rappi.movie_module.views.movies

import com.google.android.material.chip.Chip
import com.rappi.movie_module.databinding.RecommendedHolderBinding

class RecommendedViewHolder(
    private val recommendedHolderBinding: RecommendedHolderBinding,
    private val listItemClick: (Int) -> Unit
) : VideoViewHolder(recommendedHolderBinding) {
    private lateinit var videoAdapter: VideoAdapter
    fun bind(videoSection: MoviesData.RecommendedSection) = with(recommendedHolderBinding) {
        videoSection.recommendedViewData.filterOptions.map {
            val chip = Chip(this.root.context)
            chip.text = it
            filterChipGroup.addView(chip)
        }
        videoAdapter = VideoAdapter(videoSection.recommendedViewData.videos, listItemClick)
        videos.adapter = videoAdapter
    }
}