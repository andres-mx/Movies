package com.rappi.movie_module.views.movies

import com.rappi.movie_module.databinding.HeaderHolderBinding

class HeaderViewHolder(private val headerHolderBinding: HeaderHolderBinding) :
    VideoViewHolder(headerHolderBinding) {
    fun bind(headerSection: VideosData.HeaderSection) = with(headerHolderBinding) {
        titleSection.text = headerSection.headerViewData.title
    }
}