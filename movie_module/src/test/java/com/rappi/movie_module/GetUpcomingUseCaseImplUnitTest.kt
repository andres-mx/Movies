package com.rappi.movie_module

import com.rappi.movie_module.domain.GetTopRatedUseCaseImpl
import com.rappi.movie_module_api.GetMoviesUseCase
import com.rappi.movie_module_api.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import com.rappi.movie_module_api.view_state.MovieState.UpComingEmpty
import com.rappi.movie_module_api.view_state.MovieState.UpComingSuccessful
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetUpcomingUseCaseImplUnitTest {
    private lateinit var getMoviesUseCase: GetMoviesUseCase
    private val repository: MoviesRepository = mock()

    @Before
    fun setUp() {
        getMoviesUseCase = GetTopRatedUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN upcoming movies successfully WHEN GetMoviesUseCase requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(repository.getUpcoming()).thenReturn(MoviesData.movies())

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is UpComingSuccessful)
        }

    @Test
    fun `GIVEN upcoming movies successfully WHEN GetMoviesUseCase requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(repository.getUpcoming()).thenReturn(emptyList())

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is UpComingEmpty)
        }

    @Test
    fun `GIVEN upcoming movies error WHEN GetMoviesUseCase requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(repository.getUpcoming()).thenReturn(null)

            //When
            val moviesResult = getMoviesUseCase()

            //Then
            assertTrue(moviesResult is MovieState.UpComingFailure)
        }
}