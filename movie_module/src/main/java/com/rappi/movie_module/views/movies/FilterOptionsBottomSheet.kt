package com.rappi.movie_module.views.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rappi.movie_module.databinding.BottomSheetFilterOptionsBinding
import com.rappi.movie_module.view_models.FiltersViewModel
import com.rappi.movie_module.view_state.FiltersState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterOptionsBottomSheet : BottomSheetDialogFragment() {
    private val viewModel: FiltersViewModel by viewModels()
    private var _binding: BottomSheetFilterOptionsBinding? = null
    private val binding: BottomSheetFilterOptionsBinding get() = _binding!!
    private lateinit var language: String
    private lateinit var year: String
    private var position: Int = 0
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
        isCancelable = false
        setUpArguments(arguments)
        setUpObserve()
        initView()
        request()
    }

    private fun setUpArguments(arguments: Bundle?) {
        language = arguments?.getString("language").orEmpty()
        year = arguments?.getString("year").orEmpty()
    }

    private fun setUpObserve() {
        viewModel.filtersState.observe(viewLifecycleOwner) { filterState ->
            renderUi(filterState)
        }
    }

    private fun renderUi(filterState: FiltersState?) = when (filterState) {
        is FiltersState.FiltersSuccessful -> {
            filterList = filterState.filters.toMutableList()
            filterAdapter.submitList(filterState.filters.toMutableList())
        }
        is FiltersState.FilterFailure -> {}
        else -> {}
    }

    private fun initView() = with(binding) {
        filterAdapter = FilterAdapter(filterOptionSelected)
        filterOptionRecyclerView.adapter = filterAdapter
        filterOptionRecyclerView.setHasFixedSize(true)
        okButton.setOnClickListener {
            println("ValueFilter: " + filterList[position].description)
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                "filterKey",
                filterList[position].description
            )
            findNavController().popBackStack()
        }
    }

    private fun request() {
        if (language.isNotEmpty()) viewModel.getLanguages(language)
        if (year.isNotEmpty()) viewModel.getYears(year)
    }

    private val filterOptionSelected: (Int) -> Unit = { position ->
        this.position = position
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
}