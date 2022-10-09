package com.rappi.movie_module

import com.rappi.movie_module.MoviesData.LANGUAGE
import com.rappi.movie_module.MoviesData.LIMIT
import com.rappi.movie_module.MoviesData.YEAR
import com.rappi.movie_module.MoviesData.recommendedByLanguageMoviesModel
import com.rappi.movie_module.MoviesData.recommendedByYearMoviesModel
import com.rappi.movie_module.MoviesData.recommendedMoviesModel
import com.rappi.movie_module.MoviesData.topRatedMoviesModel
import com.rappi.movie_module.MoviesData.upcomingMovies
import com.rappi.movie_module.MoviesData.upcomingMoviesModel
import com.rappi.movie_module.data.LocalMovieSourceImpl
import com.rappi.movie_module_api.data.LocalMovieSource
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.database.MoviesDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LocalMovieSourceImplUnitTest {
    private var moviesDao: MoviesDao = mock()
    private lateinit var localMovieSource: LocalMovieSource

    @Before
    fun setUp() {
        localMovieSource = LocalMovieSourceImpl(moviesDao)
    }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getMovies requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.UPCOMING.name, LIMIT)).thenReturn(
                upcomingMoviesModel()
            )

            //When
            val localMovies = localMovieSource.getMovies(MovieType.UPCOMING, LIMIT)

            //Then
            assertEquals(6, localMovies.size)
        }

    @Test
    fun `GIVEN upcoming movies successfully WHEN getMovies requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.UPCOMING.name, LIMIT)).thenReturn(emptyList())

            //When
            val localMovies = localMovieSource.getMovies(MovieType.UPCOMING, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN upcoming movies error WHEN getMovies requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.UPCOMING.name, LIMIT)).thenReturn(null)

            //When
            val localMovies = localMovieSource.getMovies(MovieType.UPCOMING, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getMovies requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.TOP_RATED.name, LIMIT)).thenReturn(
                topRatedMoviesModel()
            )

            //When
            val localMovies = localMovieSource.getMovies(MovieType.TOP_RATED, LIMIT)

            //Then
            assertEquals(6, localMovies.size)
        }

    @Test
    fun `GIVEN top rated movies successfully WHEN getMovies requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.TOP_RATED.name, LIMIT)).thenReturn(emptyList())

            //When
            val localMovies = localMovieSource.getMovies(MovieType.TOP_RATED, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN top rated movies error WHEN getMovies requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.TOP_RATED.name, LIMIT)).thenReturn(null)

            //When
            val localMovies = localMovieSource.getMovies(MovieType.TOP_RATED, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies successfully WHEN getMovies requested THEN Movies is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.RECOMMENDED.name, LIMIT)).thenReturn(
                recommendedMoviesModel()
            )

            //When
            val localMovies = localMovieSource.getMovies(MovieType.RECOMMENDED, LIMIT)

            //Then
            assertEquals(6, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies successfully WHEN getMovies requested THEN Movies empty is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.RECOMMENDED.name, LIMIT)).thenReturn(emptyList())

            //When
            val localMovies = localMovieSource.getMovies(MovieType.RECOMMENDED, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies error WHEN getMovies requested THEN Movies is failure`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.RECOMMENDED.name, LIMIT)).thenReturn(null)

            //When
            val localMovies = localMovieSource.getMovies(MovieType.RECOMMENDED, LIMIT)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN getMovieByYear requested THEN Movies by year is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMoviesByYear(MovieType.RECOMMENDED.name, LIMIT, YEAR)).thenReturn(
                recommendedByYearMoviesModel()
            )

            //When
            val localMovies = localMovieSource.getMovieByYear(MovieType.RECOMMENDED, LIMIT, YEAR)

            //Then
            assertEquals(5, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by year successfully WHEN getMovieByYear requested THEN Movies by year empty is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMoviesByYear(MovieType.RECOMMENDED.name, LIMIT, YEAR)).thenReturn(
                emptyList()
            )

            //When
            val localMovies = localMovieSource.getMovieByYear(MovieType.RECOMMENDED, LIMIT, YEAR)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by year error WHEN getMovieByYear requested THEN Movies by year is failure`() =
        runTest {
            //Given
            whenever(moviesDao.getMoviesByYear(MovieType.RECOMMENDED.name, LIMIT, YEAR)).thenReturn(
                null
            )

            //When
            val localMovies = localMovieSource.getMovieByYear(MovieType.RECOMMENDED, LIMIT, YEAR)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by language successfully WHEN getMovieByYear requested THEN Movies by language is returned`() =
        runTest {
            //Given
            whenever(
                moviesDao.getMoviesByLanguage(
                    MovieType.RECOMMENDED.name.uppercase(),
                    LIMIT,
                    LANGUAGE
                )
            ).thenReturn(
                recommendedByLanguageMoviesModel()
            )

            //When
            val localMovies =
                localMovieSource.getMovieByLanguage(MovieType.RECOMMENDED, LIMIT, LANGUAGE)

            //Then
            assertEquals(3, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by language successfully WHEN getMovieByYear requested THEN Movies by language empty is returned`() =
        runTest {
            //Given
            whenever(moviesDao.getMoviesByYear(MovieType.RECOMMENDED.name, LIMIT, YEAR)).thenReturn(
                emptyList()
            )

            //When
            val localMovies = localMovieSource.getMovieByYear(MovieType.RECOMMENDED, LIMIT, YEAR)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN recommended movies by language error WHEN getMovieByYear requested THEN Movies by language is failure`() =
        runTest {
            //Given
            whenever(moviesDao.getMoviesByYear(MovieType.RECOMMENDED.name, LIMIT, YEAR)).thenReturn(
                null
            )

            //When
            val localMovies = localMovieSource.getMovieByYear(MovieType.RECOMMENDED, LIMIT, YEAR)

            //Then
            assertEquals(0, localMovies.size)
        }

    @Test
    fun `GIVEN add movies successfully WHEN addMovies requested THEN Movies is added`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.UPCOMING.name, 6)).thenReturn(
                recommendedMoviesModel()
            )
            moviesDao.addMovies(upcomingMoviesModel())

            //When
            localMovieSource.addMovies(upcomingMovies(), MovieType.UPCOMING)
            val getMovies = moviesDao.getMovies(MovieType.UPCOMING.name, 6)

            //Then
            assertEquals(6, getMovies.size)
        }

    @Test
    fun `GIVEN add movies error WHEN addMovies requested THEN Movies is not added`() =
        runTest {
            //Given
            whenever(moviesDao.getMovies(MovieType.UPCOMING.name, 6)).thenReturn(null)
            moviesDao.addMovies(recommendedMoviesModel())

            //When
            localMovieSource.addMovies(upcomingMovies(), MovieType.UPCOMING)
            val getMovies = moviesDao.getMovies(MovieType.UPCOMING.name, 6)

            //Then
            assertNull(getMovies)
        }
}