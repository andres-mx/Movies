package com.rappi.movie_module

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.rappi.movie_module.MoviesData.LIMIT
import com.rappi.movie_module.MoviesData.YEAR
import com.rappi.movie_module.MoviesData.recommendedMovies
import com.rappi.movie_module.MoviesData.topRatedMovies
import com.rappi.movie_module.MoviesData.upcomingMovies
import com.rappi.movie_module.repository.MoviesRepositoryImpl
import com.rappi.movie_module_api.data.LocalMovieSource
import com.rappi.movie_module_api.data.MovieApi
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.repository.MoviesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MoviesRepositoryImplUnitTest {
    private val movieApi: MovieApi = mock()
    private val localMovieSource: LocalMovieSource = mock()
    private lateinit var moviesRepository: MoviesRepository
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        moviesRepository = MoviesRepositoryImpl(movieApi, localMovieSource)
    }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getUpcoming requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(movieApi.getUpcoming()).thenReturn(upcomingMovies())

            //When
            val upcomingVideos = moviesRepository.getUpcoming()

            //Then
            assertEquals(6, upcomingVideos.size)
        }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getUpcoming requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(movieApi.getUpcoming()).thenReturn(emptyList())

            //When
            val upcomingVideos = moviesRepository.getUpcoming()

            //Then
            assertEquals(0, upcomingVideos.size)
        }

    @Test
    fun `GIVEN upcoming movies error WHEN getUpcoming requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(movieApi.getUpcoming()).thenReturn(null)
            whenever(localMovieSource.getMovies(MovieType.UPCOMING, LIMIT)).thenReturn(
                null
            )

            //When
            val upcomingVideos = moviesRepository.getUpcoming()

            //Then
            assertNull(upcomingVideos)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getTopRated requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(movieApi.getTopRated()).thenReturn(topRatedMovies())

            //When
            val topRatedVideos = moviesRepository.getTopRated()

            //Then
            assertEquals(6, topRatedVideos.size)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getTopRated requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(movieApi.getTopRated()).thenReturn(emptyList())

            //When
            val topRatedVideos = moviesRepository.getTopRated()

            //Then
            assertEquals(0, topRatedVideos.size)
        }

    @Test
    fun `GIVEN top rated movies error WHEN getTopRated requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(movieApi.getTopRated()).thenReturn(null)
            whenever(localMovieSource.getMovies(MovieType.TOP_RATED, LIMIT)).thenReturn(
                null
            )

            //When
            val topRatedVideos = moviesRepository.getTopRated()

            //Then
            assertNull(topRatedVideos)
        }

    @Test
    fun `GIVEN recommended movies successfully WHEN getRecommended requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(movieApi.getRecommended()).thenReturn(recommendedMovies())

            //When
            val recommendedVideos = moviesRepository.getRecommended()

            //Then
            assertEquals(6, recommendedVideos.size)
        }

    @Test
    fun `GIVEN recommended movies successfully WHEN getRecommended requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(movieApi.getRecommended()).thenReturn(emptyList())

            //When
            val recommendedVideos = moviesRepository.getRecommended()

            //Then
            assertEquals(0, recommendedVideos.size)
        }

    @Test
    fun `GIVEN recommended movies error WHEN getTopRated requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(movieApi.getRecommended()).thenReturn(null)
            whenever(
                localMovieSource.getMovies(
                    MovieType.RECOMMENDED,
                    LIMIT
                )
            ).thenReturn(emptyList())

            //When
            val recommendedVideos = moviesRepository.getRecommended()

            //Then
            assertEquals(0, recommendedVideos.size)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN getRecommended requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(
                localMovieSource.getMovieByYear(
                    MovieType.RECOMMENDED,
                    LIMIT,
                    YEAR
                )
            ).thenReturn(
                recommendedMovies()
            )

            //When
            val recommendedVideos = moviesRepository.getMovieByYear(MovieType.RECOMMENDED, YEAR)

            //Then
            assertEquals(6, recommendedVideos.size)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN getRecommended requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(
                localMovieSource.getMovieByYear(
                    MovieType.RECOMMENDED,
                    LIMIT,
                    YEAR
                )
            ).thenReturn(
                emptyList()
            )

            //When
            val recommendedVideos = moviesRepository.getMovieByYear(MovieType.RECOMMENDED, YEAR)

            //Then
            assertEquals(0, recommendedVideos.size)
        }

    @Test
    fun `GIVEN recommended movies year error WHEN getTopRated requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(
                localMovieSource.getMovies(
                    MovieType.RECOMMENDED,
                    LIMIT
                )
            ).thenReturn(null)

            //When
            val recommendedVideos = moviesRepository.getMovieByYear(MovieType.RECOMMENDED, YEAR)

            //Then
            assertNull(recommendedVideos)
        }
}