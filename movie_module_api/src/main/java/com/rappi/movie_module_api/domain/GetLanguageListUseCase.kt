package com.rappi.movie_module_api.domain

interface GetLanguageListUseCase {
    suspend operator fun invoke(): List<String>
}