package com.rappi.detail_module

import com.rappi.detail_module.DetailData.getDetailMovie
import com.rappi.detail_module.domain.GetMovieDetailUseCaseImpl
import com.rappi.detail_module_api.domain.GetMovieDetailUseCase
import com.rappi.detail_module_api.repository.DetailRepository
import com.rappi.detail_module_api.view_state.MovieDetailState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetMovieDetailUseCaseImplUnitTest {
    private lateinit var getMovieDetailUseCase: GetMovieDetailUseCase
    private val repository: DetailRepository = mock()

    @Before
    fun setUp() {
        getMovieDetailUseCase = GetMovieDetailUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN detail movie by id WHEN GetDetailMovieUseCase requested THEN DetailMovie is returned`() =
        runTest {
            //Given
            whenever(repository.getDetailMovie(1)).thenReturn(getDetailMovie())

            //When
            val movieDetail = getMovieDetailUseCase(1)

            //Then
            assertTrue(movieDetail is MovieDetailState.MovieDetailSuccessful)
        }

    @Test
    fun `GIVEN detail movie by id WHEN GetDetailMovieUseCase requested THEN DetailMovie is null returned`() =
        runTest {
            //Given
            whenever(repository.getDetailMovie(1)).thenReturn(null)

            //When
            val movieDetail = getMovieDetailUseCase(1)

            //Then
            assertTrue(movieDetail is MovieDetailState.MovieDetailEmpty)
        }
}