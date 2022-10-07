package com.rappi.movie_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movie_module.view_state.FiltersState
import com.rappi.movie_module.views.movies.FilterOptionViewData
import com.rappi.movie_module_api.domain.GetLanguageListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(private val getLanguageListUseCase: GetLanguageListUseCase) :
    ViewModel() {
    private val _filtersState: MutableLiveData<FiltersState> = MutableLiveData()
    val filtersState: LiveData<FiltersState> get() = _filtersState

    fun getLanguages(language: String) {
        try {
            _filtersState.postValue(FiltersState.Idle)
            viewModelScope.launch(Dispatchers.IO) {
                val languages = getLanguageListUseCase()
                val filters = getFilters(languages)
                _filtersState.postValue(FiltersState.FiltersSuccessful(filters))
            }
        } catch (ex: Exception) {
            _filtersState.postValue(FiltersState.FilterFailure)
        }
    }

    private fun getFilters(languages: List<String>): List<FilterOptionViewData> {
        val filters = mutableListOf<FilterOptionViewData>()
        languages.map {
            filters.add(FilterOptionViewData(it, false))
        }
        return filters
    }
}