package com.rappi.movie_module.domain

import com.rappi.movie_module.R
import com.rappi.movie_module_api.domain.GetRecommendedUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import javax.inject.Inject

class GetRecommendedUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetRecommendedUseCase {
    override suspend fun invoke(language: String, year: String): MovieState {
        MovieState.Idle
        return try {
            val movies = moviesRepository.getRecommended(language, year)
            if (movies.isEmpty()) {
                MovieState.RecommendedEmpty
            } else {
                MovieState.RecommendedSuccessful(movies)
            }
        } catch (e: Exception) {
            MovieState.RecommendedFailure(R.string.top_rated_error)
        }
    }
}