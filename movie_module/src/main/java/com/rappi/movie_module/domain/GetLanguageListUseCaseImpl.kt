package com.rappi.movie_module.domain

import com.rappi.movie_module_api.domain.GetLanguageListUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import javax.inject.Inject

class GetLanguageListUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    GetLanguageListUseCase {
    override suspend fun invoke(): List<String> =
        moviesRepository.getLanguages()
}