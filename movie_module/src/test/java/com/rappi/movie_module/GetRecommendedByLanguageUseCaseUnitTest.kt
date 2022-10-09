package com.rappi.movie_module

import com.rappi.movie_module.MoviesData.LANGUAGE
import com.rappi.movie_module.domain.GetRecommendedByLanguageUseCaseImpl
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.domain.GetRecommendedByLanguageUseCase
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
class GetRecommendedByLanguageUseCaseUnitTest {
    private lateinit var getRecommendedByLanguageUseCase: GetRecommendedByLanguageUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getRecommendedByLanguageUseCase = GetRecommendedByLanguageUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN recommended movies by language successfully WHEN GetRecommendedByLanguageUseCase requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(repository.getMovieByLanguage(MovieType.RECOMMENDED, LANGUAGE)).thenReturn(
                MoviesData.recommendedMovies()
            )

            //When
            val moviesResult = getRecommendedByLanguageUseCase(MovieType.RECOMMENDED, LANGUAGE)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedSuccessful)
        }

    @Test
    fun `GIVEN recommended movies by language successfully WHEN GetRecommendedByLanguageUseCase requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(repository.getMovieByLanguage(MovieType.RECOMMENDED, LANGUAGE)).thenReturn(
                emptyList()
            )

            //When
            val moviesResult = getRecommendedByLanguageUseCase(MovieType.RECOMMENDED, LANGUAGE)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedEmpty)
        }

    @Test
    fun `GIVEN recommended movies by language error WHEN GetRecommendedByLanguageUseCase requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(repository.getMovieByLanguage(MovieType.RECOMMENDED, LANGUAGE)).thenReturn(null)

            //When
            val moviesResult = getRecommendedByLanguageUseCase(MovieType.RECOMMENDED, LANGUAGE)

            //Then
            Assert.assertTrue(moviesResult is MovieState.RecommendedFailure)
        }
}