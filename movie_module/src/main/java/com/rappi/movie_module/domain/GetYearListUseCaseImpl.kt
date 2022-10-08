package com.rappi.movie_module.domain

import com.rappi.movie_module_api.domain.GetYearListUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import javax.inject.Inject

class GetYearListUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetYearListUseCase {
    override suspend fun invoke(): List<String> = moviesRepository.getYear()
}