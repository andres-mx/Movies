package com.rappi.movie_module.domain

import com.rappi.movie_module.R
import com.rappi.movie_module_api.GetMoviesUseCase
import com.rappi.movie_module_api.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import com.rappi.movie_module_api.view_state.MovieState.MovieFailure
import com.rappi.movie_module_api.view_state.MovieState.UpComingSuccessful
import javax.inject.Inject

class GetUpcomingUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetMoviesUseCase {
    override suspend fun invoke(): MovieState {
        MovieState.Idle
        return try {
            val movies = moviesRepository.getUpcoming()
            if (movies.isEmpty()) {
                MovieState.UpComingEmpty
            } else {
                UpComingSuccessful(movies)
            }
        } catch (e: Exception) {
            MovieFailure(R.string.upcoming_error)
        }
    }
}