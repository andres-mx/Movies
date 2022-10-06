package com.rappi.movie_module.views.movies

import androidx.recyclerview.widget.RecyclerView
import com.rappi.movie_module.databinding.OptionFilterHolderBinding

class FilterViewHolder(
    private val binding: OptionFilterHolderBinding,
    private val listItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(filterOptionViewData: FilterOptionViewData) = with(binding) {
        optionFilterRadioButton.text = filterOptionViewData.description
        optionFilterRadioButton.isChecked = filterOptionViewData.isSelected
        optionFilterRadioButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                listItemClick(adapterPosition)
            }
        }
    }
}