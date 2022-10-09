package com.rappi.movie_module.views.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rappi.movie_module.databinding.BottomSheetFilterOptionsBinding
import com.rappi.movie_module.utils.MovieUtils.FILTER_KEY_STRING
import com.rappi.movie_module.utils.MovieUtils.LANGUAGE_STRING
import com.rappi.movie_module.utils.MovieUtils.YEAR_STRING
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
        language = arguments?.getString(LANGUAGE_STRING).orEmpty()
        year = arguments?.getString(YEAR_STRING).orEmpty()
    }

    private fun setUpObserve() {
        viewModel.filtersState.observe(viewLifecycleOwner) { filterState ->
            renderUi(filterState)
        }
    }

    private fun renderUi(filterState: FiltersState?) = when (filterState) {
        is FiltersState.FiltersSuccessful -> {
            recyclerViewFill(filterState.filters)
        }
        is FiltersState.FilterFailure -> {}
        else -> {}
    }

    private fun recyclerViewFill(list: List<FilterOptionViewData>) = with(binding) {
        binding.filterOptionRecyclerView.adapter = filterAdapter
        filterList = list.toMutableList()
        filterAdapter.submitList(list.toMutableList())
    }

    private fun initView() = with(binding) {
        filterAdapter = FilterAdapter(filterOptionSelected)
        filterOptionRecyclerView.setHasFixedSize(true)
        okButton.setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set(
                FILTER_KEY_STRING,
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