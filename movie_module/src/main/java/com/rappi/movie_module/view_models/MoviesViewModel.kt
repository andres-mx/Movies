package com.rappi.movie_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movie_module.utils.MovieUtils.getVideosData
import com.rappi.movie_module.view_state.MovieViewState
import com.rappi.movie_module_api.TopRated
import com.rappi.movie_module_api.Upcoming
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.domain.GetMoviesUseCase
import com.rappi.movie_module_api.domain.GetRecommendedByLanguageUseCase
import com.rappi.movie_module_api.domain.GetRecommendedByYearUseCase
import com.rappi.movie_module_api.domain.GetRecommendedUseCase
import com.rappi.movie_module_api.view_state.MovieState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    @Upcoming private val getUpcomingUseCase: GetMoviesUseCase,
    @TopRated private val getTopRatedUseCase: GetMoviesUseCase,
    private val getRecommendedUseCase: GetRecommendedUseCase,
    private val getRecommendedByYearUseCase: GetRecommendedByYearUseCase,
    private val getRecommendedByLanguageUseCase: GetRecommendedByLanguageUseCase
) : ViewModel() {
    private val _moviesViewState: MutableLiveData<MovieViewState> = MutableLiveData()
    val moviesViewState: LiveData<MovieViewState> get() = _moviesViewState

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _moviesViewState.postValue(MovieViewState.Idle)
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

                val recommended = when (val movies = getRecommendedUseCase()) {
                    is MovieState.RecommendedSuccessful -> {
                        movies.movies
                    }
                    else -> {
                        emptyList()
                    }
                }

                val videos = getVideosData(
                    MoviesDataToConvert(
                        upComings = upComings,
                        topRatedList = topRated,
                        recommendedList = recommended
                    )
                )
                if (videos.isEmpty()) {
                    _moviesViewState.postValue(MovieViewState.MoviesFailure("Error al consumir el servicio del detalle de la película"))
                } else {
                    _moviesViewState.postValue(MovieViewState.MoviesSuccessful(videos))
                }
            } catch (ex: Exception) {
                _moviesViewState.postValue(MovieViewState.MoviesFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }

    fun getRecommendedByYear(year: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _moviesViewState.postValue(MovieViewState.Idle)
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

                val recommended = when (val movies =
                    getRecommendedByYearUseCase(MovieType.RECOMMENDED, year)) {
                    is MovieState.RecommendedSuccessful -> {
                        movies.movies
                    }
                    else -> {
                        emptyList()
                    }
                }
                val videos = getVideosData(
                    MoviesDataToConvert(
                        upComings = upComings,
                        topRatedList = topRated,
                        recommendedList = recommended,
                        year = year
                    )
                )
                if (videos.isEmpty()) {
                    _moviesViewState.postValue(MovieViewState.MoviesFailure("Error al consumir el servicio del detalle de la película"))
                } else {
                    _moviesViewState.postValue(MovieViewState.MoviesSuccessful(videos))
                }
            } catch (ex: Exception) {
                _moviesViewState.postValue(MovieViewState.MoviesFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }

    fun getRecommendedByLanguage(language: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _moviesViewState.postValue(MovieViewState.Idle)
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

                val recommended = when (val movies =
                    getRecommendedByLanguageUseCase(MovieType.RECOMMENDED, language)) {
                    is MovieState.RecommendedSuccessful -> {
                        movies.movies
                    }
                    else -> {
                        emptyList()
                    }
                }
                val videos = getVideosData(
                    MoviesDataToConvert(
                        upComings = upComings,
                        topRatedList = topRated,
                        recommendedList = recommended,
                        language = language
                    )
                )
                if (videos.isEmpty()) {
                    _moviesViewState.postValue(MovieViewState.MoviesFailure("Error al consumir el servicio del detalle de la película"))
                } else {
                    _moviesViewState.postValue(MovieViewState.MoviesSuccessful(videos))
                }
            } catch (ex: Exception) {
                _moviesViewState.postValue(MovieViewState.MoviesFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }
}