package com.rappi.movie_module

import com.rappi.movie_module.MoviesData.LANGUAGE
import com.rappi.movie_module.MoviesData.YEAR
import com.rappi.movie_module.domain.GetRecommendedUseCaseImpl
import com.rappi.movie_module_api.GetRecommendedUseCase
import com.rappi.movie_module_api.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetRecommendedUseCaseImplUnitTest {
    private lateinit var getRecommendedUseCase: GetRecommendedUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getRecommendedUseCase = GetRecommendedUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN recommended movies by language and year successfully WHEN GetRecommendedUseCase requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(repository.getRecommended(LANGUAGE, YEAR)).thenReturn(MoviesData.movies())

            //When
            val moviesResult = getRecommendedUseCase(LANGUAGE, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedSuccessful)
        }

    @Test
    fun `GIVEN recommended movies by language and year successfully WHEN GetRecommendedUseCase requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(repository.getRecommended(LANGUAGE, YEAR)).thenReturn(emptyList())

            //When
            val moviesResult = getRecommendedUseCase(LANGUAGE, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedEmpty)
        }

    @Test
    fun `GIVEN recommended movies by language and year error WHEN GetRecommendedUseCase requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(repository.getRecommended(LANGUAGE, YEAR)).thenReturn(null)

            //When
            val moviesResult = getRecommendedUseCase(LANGUAGE, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedFailure)
        }
}