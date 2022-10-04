package com.rappi.detail_module

import com.rappi.detail_module.data.DetailMovieResponse
import com.rappi.detail_module.data.MovieDetailApiImpl
import com.rappi.detail_module.data.MovieDetailService
import com.rappi.detail_module_api.data.MovieDetailApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MovieDetailApiImplUnitTest {
    private lateinit var movieDetailApi: MovieDetailApi
    private var services: MovieDetailService = mock()

    @Before
    fun setUp() {
        services = mock(MovieDetailService::class.java)
        movieDetailApi = MovieDetailApiImpl(services)
    }

    @Test
    fun `GIVEN movie detail successfully WHEN movie requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(services.getMovieDetail(movieId = 70)).thenReturn(DetailMovieResponse(id = 70))

            //When
            val movieDetailResult = movieDetailApi.getDetailMovie(70)

            //Then
            Assert.assertNotNull(movieDetailResult)
        }

    @Test
    fun `GIVEN movie detail successfully WHEN movie requested THEN movieId is null`() =
        runTest {
            //Given
            whenever(services.getMovieDetail(movieId = 70)).thenReturn(DetailMovieResponse(id = null))

            //When
            val movieDetailResult = movieDetailApi.getDetailMovie(70)

            //Then
            Assert.assertNull(movieDetailResult?.movieId)
        }

    @Test
    fun `GIVEN movie detail successfully WHEN movie requested THEN Movies is null`() =
        runTest {
            //Given
            whenever(services.getMovieDetail(movieId = 70)).thenReturn(null)

            //When
            val movieDetailResult = movieDetailApi.getDetailMovie(70)

            //Then
            Assert.assertNull(movieDetailResult?.movieId)
        }
}