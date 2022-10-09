package com.rappi.movie_module

import com.rappi.movie_module.domain.GetTopRatedUseCaseImpl
import com.rappi.movie_module_api.domain.GetMoviesUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetTopRatedUseCaseImplUnitTest {
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getMoviesUseCase = GetTopRatedUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN top rated movies successfully WHEN GetMoviesUseCase requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(repository.getTopRated()).thenReturn(MoviesData.topRatedMovies())

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is MovieState.TopRatedSuccessful)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN GetMoviesUseCase requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(repository.getTopRated()).thenReturn(emptyList())

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is MovieState.TopRatedEmpty)
        }

    @Test
    fun `GIVEN top rated movies error WHEN GetMoviesUseCase requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(repository.getTopRated()).thenReturn(null)

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is MovieState.TopRatedFailure)
        }

}