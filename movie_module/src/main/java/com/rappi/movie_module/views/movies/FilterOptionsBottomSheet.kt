package com.rappi.movie_module.views.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rappi.movie_module.databinding.BottomSheetFilterOptionsBinding

class FilterOptionsBottomSheet : BottomSheetDialogFragment() {
    private var _binding: BottomSheetFilterOptionsBinding? = null
    private val binding: BottomSheetFilterOptionsBinding get() = _binding!!
    private lateinit var filterAdapter: FilterAdapter
    private var filterList: MutableList<FilterOptionViewData> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetFilterOptionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {
        filterAdapter = FilterAdapter(filterOptionSelected)
        filterOptionRecyclerView.adapter = filterAdapter
        filterOptionRecyclerView.setHasFixedSize(true)
        filterAdapter.submitList(dummy())
    }

    private val filterOptionSelected: (Int) -> Unit = { position ->
        dummy2(position)
    }

    private fun dummy2(position: Int) = with(binding) {
        val newFilterList = mutableListOf<FilterOptionViewData>()
        filterList.map {
            newFilterList.add(FilterOptionViewData(it.copy().description, false))
        }
        newFilterList[position].isSelected = true
        filterAdapter.submitList(newFilterList)
    }

    private fun dummy(): MutableList<FilterOptionViewData> {
        filterList.add(FilterOptionViewData("1993", false))
        filterList.add(FilterOptionViewData("1994", false))
        filterList.add(FilterOptionViewData("1995", false))
        return filterList
    }
}