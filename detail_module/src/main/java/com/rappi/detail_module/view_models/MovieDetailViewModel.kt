package com.rappi.detail_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.detail_module.BuildConfig
import com.rappi.detail_module.view_state.MovieDetailViewState
import com.rappi.detail_module.views.MovieDetailViewData
import com.rappi.detail_module_api.data.DetailMovie
import com.rappi.detail_module_api.domain.GetMovieDetailUseCase
import com.rappi.detail_module_api.view_state.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase) :
    ViewModel() {
    private val _movieDetailViewState: MutableLiveData<MovieDetailViewState> = MutableLiveData()
    val movieDetailViewState: LiveData<MovieDetailViewState> get() = _movieDetailViewState

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val movieDetail = when (val movie = getMovieDetailUseCase(movieId)) {
                    is MovieDetailState.MovieDetailSuccessful -> {
                        movie.detailMovie
                    }
                    else -> {
                        null
                    }
                }
                val detail = movieDetail.toMovieDetailViewData()
                _movieDetailViewState.postValue(MovieDetailViewState.MovieDetailSuccessful(detail))
            } catch (ex: Exception) {
                _movieDetailViewState.postValue(MovieDetailViewState.MovieDetailFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }
}

private fun DetailMovie?.toMovieDetailViewData() = MovieDetailViewData(
    movieId = this?.movieId ?: 0,
    imageUrl = BuildConfig.URLIMAGES + this?.imageUrl.orEmpty(),
    year = this?.year.orEmpty(),
    language = this?.language.orEmpty(),
    title = this?.title.orEmpty(),
    originalTitle = this?.originalTitle.orEmpty(),
    description = this?.description.orEmpty()
)
