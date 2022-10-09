package com.rappi.movie_module

import com.rappi.movie_module.domain.GetLanguageListUseCaseImpl
import com.rappi.movie_module_api.domain.GetLanguageListUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetLanguageListUseCaseImplUnitTest {
    private lateinit var getLanguageListUseCase: GetLanguageListUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getLanguageListUseCase = GetLanguageListUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN filters by language successfully WHEN GetLanguageListUseCase requested THEN Filters is returned`() =
        runTest {
            //Given
            whenever(repository.getLanguages()).thenReturn(listOf("en", "fr", "es"))

            //When
            val moviesResult = getLanguageListUseCase()

            //Then
            assertEquals(3, moviesResult.size)
        }

    @Test
    fun `GIVEN filters by language successfully WHEN GetLanguageListUseCase requested THEN Filters empty is returned`() =
        runTest {
            //Given
            whenever(repository.getLanguages()).thenReturn(emptyList())

            //When
            val moviesResult = getLanguageListUseCase()

            //Then
            assertEquals(0, moviesResult.size)
        }

    @Test
    fun `GIVEN filters by language successfully WHEN GetLanguageListUseCase requested THEN Filters null is returned`() =
        runTest {
            //Given
            whenever(repository.getLanguages()).thenReturn(null)

            //When
            val moviesResult = getLanguageListUseCase()

            //Then
            assertNull(moviesResult)
        }
}