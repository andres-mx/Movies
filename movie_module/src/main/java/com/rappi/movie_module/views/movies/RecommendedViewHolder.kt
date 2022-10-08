package com.rappi.movie_module.views.movies

import com.google.android.material.chip.Chip
import com.rappi.movie_module.databinding.RecommendedHolderBinding

class RecommendedViewHolder(
    private val recommendedHolderBinding: RecommendedHolderBinding,
    private val listItemClick: (Int) -> Unit,
    private val filterItemClick: (Int) -> Unit
) : VideoViewHolder(recommendedHolderBinding) {
    private lateinit var videoAdapter: VideoAdapter
    fun bind(videoSection: MoviesData.RecommendedSection) = with(recommendedHolderBinding) {
        videoSection.recommendedViewData.filterOptions.map { filter ->
            val chip = Chip(this.root.context)
            chip.text = filter.value
            chip.isClickable = true
            filterChipGroup.addView(chip)
            chip.setOnClickListener {
                filterItemClick(filter.key)
            }
        }
        videoAdapter = VideoAdapter(videoSection.recommendedViewData.videos, listItemClick)
        videos.adapter = videoAdapter
    }
}