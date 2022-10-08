package com.rappi.movie_module_api.domain

interface GetYearListUseCase {
    suspend operator fun invoke(): List<String>
}