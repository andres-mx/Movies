package com.rappi.movie_module.views.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rappi.movie_module.databinding.OptionFilterHolderBinding

class FilterAdapter(private val listItemClick: (Int) -> Unit) :
    ListAdapter<FilterOptionViewData, FilterViewHolder>(COMPARATOR) {
    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<FilterOptionViewData>() {
            override fun areItemsTheSame(
                oldItem: FilterOptionViewData,
                newItem: FilterOptionViewData
            ): Boolean {
                return oldItem.isSelected == newItem.isSelected
            }

            override fun areContentsTheSame(
                oldItem: FilterOptionViewData,
                newItem: FilterOptionViewData
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder =
        FilterViewHolder(
            OptionFilterHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            listItemClick
        )

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<FilterOptionViewData>?) {
        super.submitList(list?.toList())
    }
}