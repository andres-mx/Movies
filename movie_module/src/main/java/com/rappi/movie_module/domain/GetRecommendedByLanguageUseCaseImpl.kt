package com.rappi.movie_module.domain

import com.rappi.movie_module.R
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.domain.GetRecommendedByLanguageUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import javax.inject.Inject

class GetRecommendedByLanguageUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetRecommendedByLanguageUseCase {
    override suspend fun invoke(movieType: MovieType, language: String): MovieState {
        MovieState.Idle
        return try {
            val movies = moviesRepository.getMovieByLanguage(movieType, language)
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