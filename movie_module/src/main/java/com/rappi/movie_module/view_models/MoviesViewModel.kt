package com.rappi.movie_module.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movie_module.view_state.MovieViewState
import com.rappi.movie_module_api.GetMoviesUseCase
import com.rappi.movie_module_api.view_state.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val getUpcomingUseCase: GetMoviesUseCase) :
    ViewModel() {
    private val _moviesViewState: MutableLiveData<MovieViewState> = MutableLiveData()
    val moviesViewState: LiveData<MovieViewState> get() = _moviesViewState

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                when (val movies = getUpcomingUseCase()) {
                    is MovieState.UpComingSuccessful -> {
                        _moviesViewState.postValue(MovieViewState.MoviesSuccessful(movies.movies))
                    }
                    else -> {
                        _moviesViewState.postValue(MovieViewState.Idle)
                    }
                }
            } catch (ex: Exception) {
                _moviesViewState.postValue(MovieViewState.MoviesFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }
}