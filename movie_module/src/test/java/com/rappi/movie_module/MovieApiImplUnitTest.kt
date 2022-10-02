package com.rappi.movie_module

import com.rappi.movie_module.data.MovieApiImpl
import com.rappi.movie_module.data.MovieResponse
import com.rappi.movie_module.data.MovieService
import com.rappi.movie_module_api.data.MovieApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MovieApiImplUnitTest {
    private lateinit var movieApi: MovieApi
    private lateinit var services: MovieService

    @Before
    fun setUp() {
        services = mock(MovieService::class.java)
        movieApi = MovieApiImpl(services)
    }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getUpcoming requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(services.getUpcoming()).thenReturn(MoviesData.moviesResponse())

            //When
            val upcomingResult = movieApi.getUpcoming()

            //Then
            Assert.assertEquals(6, upcomingResult.size)
        }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getUpcoming requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(services.getUpcoming()).thenReturn(MovieResponse())

            //When
            val upcomingResult = movieApi.getUpcoming()

            //Then
            Assert.assertEquals(0, upcomingResult.size)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getUpcoming requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(services.getTopRated()).thenReturn(MoviesData.moviesResponse())

            //When
            val topRatedResult = movieApi.getTopRated()

            //Then
            Assert.assertEquals(6, topRatedResult.size)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getUpcoming requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(services.getTopRated()).thenReturn(MovieResponse())

            //When
            val topRatedResult = movieApi.getTopRated()

            //Then
            Assert.assertEquals(0, topRatedResult.size)
        }
}