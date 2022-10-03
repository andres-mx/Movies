package com.rappi.movie_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movie_module.utils.MovieUtils.getVideosData
import com.rappi.movie_module.view_state.MovieViewState
import com.rappi.movie_module_api.GetMoviesUseCase
import com.rappi.movie_module_api.TopRated
import com.rappi.movie_module_api.Upcoming
import com.rappi.movie_module_api.view_state.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    @Upcoming private val getUpcomingUseCase: GetMoviesUseCase,
    @TopRated private val getTopRatedUseCase: GetMoviesUseCase
) :
    ViewModel() {
    private val _moviesViewState: MutableLiveData<MovieViewState> = MutableLiveData()
    val moviesViewState: LiveData<MovieViewState> get() = _moviesViewState

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val upComings = when (val movies = getUpcomingUseCase()) {
                    is MovieState.UpComingSuccessful -> {
                        movies.movies
                    }
                    else -> {
                        emptyList()
                    }
                }

                val topRated = when (val movies = getTopRatedUseCase()) {
                    is MovieState.TopRatedSuccessful -> {
                        movies.movies
                    }
                    else -> {
                        emptyList()
                    }
                }

                val videos = getVideosData(upComings, topRated)
                _moviesViewState.postValue(MovieViewState.MoviesSuccessful(videos))
            } catch (ex: Exception) {
                _moviesViewState.postValue(MovieViewState.MoviesFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }
}