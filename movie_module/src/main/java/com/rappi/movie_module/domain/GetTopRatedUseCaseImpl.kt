package com.rappi.movie_module.domain

import com.rappi.movie_module.R.string.top_rated_error
import com.rappi.movie_module_api.domain.GetMoviesUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import javax.inject.Inject

class GetTopRatedUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesUseCase {
    override suspend fun invoke(): MovieState {
        MovieState.Idle
        return try {
            val movies = moviesRepository.getTopRated()
            if (movies.isEmpty()) {
                MovieState.TopRatedEmpty
            } else {
                MovieState.TopRatedSuccessful(movies)
            }
        } catch (e: Exception) {
            MovieState.TopRatedFailure(top_rated_error)
        }
    }
}