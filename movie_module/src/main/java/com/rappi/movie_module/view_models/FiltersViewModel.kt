package com.rappi.movie_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movie_module.utils.MovieUtils.getFilters
import com.rappi.movie_module.view_state.FiltersState
import com.rappi.movie_module_api.domain.GetLanguageListUseCase
import com.rappi.movie_module_api.domain.GetYearListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(
    private val getLanguageListUseCase: GetLanguageListUseCase,
    private val getYearListUseCase: GetYearListUseCase
) :
    ViewModel() {
    private val _filtersState: MutableLiveData<FiltersState> = MutableLiveData()
    val filtersState: LiveData<FiltersState> get() = _filtersState

    fun getLanguages(language: String) {
        try {
            _filtersState.postValue(FiltersState.Idle)
            viewModelScope.launch(Dispatchers.IO) {
                val languages = getLanguageListUseCase()
                val filters = getFilters(languages, language)
                _filtersState.postValue(FiltersState.FiltersSuccessful(filters))
            }
        } catch (ex: Exception) {
            _filtersState.postValue(FiltersState.FilterFailure)
        }
    }

    fun getYears(year: String) {
        try {
            _filtersState.postValue(FiltersState.Idle)
            viewModelScope.launch(Dispatchers.IO) {
                val years = getYearListUseCase()
                val filters = getFilters(years, year)
                _filtersState.postValue(FiltersState.FiltersSuccessful(filters))
            }
        } catch (ex: Exception) {
            _filtersState.postValue(FiltersState.FilterFailure)
        }
    }
}