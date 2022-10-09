package com.rappi.movie_module

import com.rappi.movie_module.MoviesData.YEAR
import com.rappi.movie_module.domain.GetRecommendedByYearUseCaseImpl
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.domain.GetRecommendedByYearUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetRecommendedByYearUseCaseUnitTest {
    private lateinit var getRecommendedByYearUseCase: GetRecommendedByYearUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getRecommendedByYearUseCase = GetRecommendedByYearUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN GetRecommendedByYearUseCase requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(
                repository.getMovieByYear(
                    MovieType.RECOMMENDED,
                    YEAR
                )
            ).thenReturn(MoviesData.recommendedMovies())

            //When
            val moviesResult = getRecommendedByYearUseCase(MovieType.RECOMMENDED, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedSuccessful)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN GetRecommendedByYearUseCase requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(
                repository.getMovieByYear(
                    MovieType.RECOMMENDED,
                    YEAR
                )
            ).thenReturn(emptyList())

            //When
            val moviesResult = getRecommendedByYearUseCase(MovieType.RECOMMENDED, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedEmpty)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN GetRecommendedByYearUseCase requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(
                repository.getMovieByYear(
                    MovieType.RECOMMENDED,
                    YEAR
                )
            ).thenReturn(null)

            //When
            val moviesResult = getRecommendedByYearUseCase(MovieType.RECOMMENDED, YEAR)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedFailure)
        }

}