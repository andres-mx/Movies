package com.rappi.trailer_module.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.trailer_module.view_state.TrailerViewState
import com.rappi.trailer_module_api.domain.GetTrailerUseCase
import com.rappi.trailer_module_api.view_state.TrailerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrailerViewModel @Inject constructor(private val getTrailerUseCase: GetTrailerUseCase) :
    ViewModel() {
    private val _trailerViewState: MutableLiveData<TrailerViewState> = MutableLiveData()
    val trailerViewState: LiveData<TrailerViewState> get() = _trailerViewState

    fun getTrailer(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _trailerViewState.postValue(TrailerViewState.Idle)
                val trailer = when (val trailerResponse = getTrailerUseCase(movieId)) {
                    is TrailerState.TrailerSuccessful -> {
                        trailerResponse.trailer
                    }
                    else -> {
                        null
                    }
                }
                _trailerViewState.postValue(TrailerViewState.TrailerSuccessful(trailer?.trailerUrl.orEmpty()))
            } catch (ex: Exception) {
                _trailerViewState.postValue(TrailerViewState.TrailerFailure(ex.localizedMessage.orEmpty()))
            }
        }
    }
}