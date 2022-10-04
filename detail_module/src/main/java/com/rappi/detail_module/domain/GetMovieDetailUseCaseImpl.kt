package com.rappi.detail_module.domain

import com.rappi.detail_module.R
import com.rappi.detail_module_api.domain.GetMovieDetailUseCase
import com.rappi.detail_module_api.repository.DetailRepository
import com.rappi.detail_module_api.view_state.MovieDetailState
import javax.inject.Inject

class GetMovieDetailUseCaseImpl @Inject constructor(private val detailRepository: DetailRepository) :
    GetMovieDetailUseCase {
    override suspend fun invoke(movieId: Int): MovieDetailState {
        MovieDetailState.Idle
        return try {
            val movie = detailRepository.getDetailMovie(movieId)
            if (movie == null) {
                MovieDetailState.MovieDetailEmpty
            } else {
                MovieDetailState.MovieDetailSuccessful(movie)
            }
        } catch (e: Exception) {
            MovieDetailState.MovieDetailFailure(R.string.movie_detail_error)
        }
    }
}