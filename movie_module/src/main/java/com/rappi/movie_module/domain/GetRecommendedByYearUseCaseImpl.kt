package com.rappi.movie_module.domain

import com.rappi.movie_module.R
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.domain.GetRecommendedByYearUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import javax.inject.Inject

class GetRecommendedByYearUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetRecommendedByYearUseCase {
    override suspend fun invoke(movieType: MovieType, year: String): MovieState {
        MovieState.Idle
        return try {
            val movies = moviesRepository.getMovieByYear(movieType, year)
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