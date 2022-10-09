package com.rappi.movie_module

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rappi.movie_module.domain.GetTopRatedUseCaseImpl
import com.rappi.movie_module.domain.GetUpcomingUseCaseImpl
import com.rappi.movie_module.view_models.MoviesViewModel
import com.rappi.movie_module.view_state.MovieViewState
import com.rappi.movie_module_api.domain.GetMoviesUseCase
import com.rappi.movie_module_api.repository.MoviesRepository
import com.rappi.movie_module_api.view_state.MovieState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MoviesViewModelUnitTest {
    private lateinit var moviesViewModel: MoviesViewModel
    private lateinit var getUpcomingUseCase: GetMoviesUseCase
    private lateinit var getTopRatedUseCase: GetMoviesUseCase
    private var moviesRepository: MoviesRepository = mock()
    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        getUpcomingUseCase = GetUpcomingUseCaseImpl(moviesRepository)
        getTopRatedUseCase = GetTopRatedUseCaseImpl(moviesRepository)
    }

    /*@Test
    fun `GIVEN upcoming movies successfully WHEN GetMoviesUseCase requested THEN Movies is returned`() =
        runBlocking {
            //Given
            whenever(getUpcomingUseCase()).thenReturn(MovieState.UpComingSuccessful(listOf()))
            //When
            moviesViewModel.getMovies()
            val moviesState = moviesViewModel.moviesViewState.value

            //Then
            assertTrue(moviesState is MovieViewState.MoviesSuccessful)
        }*/
}