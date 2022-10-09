package com.rappi.detail_module

import com.rappi.detail_module.DetailData.MOVIE_ID
import com.rappi.detail_module.DetailData.getMovieDetailModel
import com.rappi.detail_module.data.LocalMovieDetailSourceImpl
import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.database.MovieDetailDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class LocalMovieDetailSourceImplUnitTest {
    private val movieDetailDao: MovieDetailDao = mock()
    private lateinit var localMovieDetailSource: LocalMovieDetailSource

    @Before
    fun setUp() {
        localMovieDetailSource = LocalMovieDetailSourceImpl(movieDetailDao)
    }

    @Test
    fun `GIVEN movie detail successfully WHEN getMovieDetail requested THEN movie detail is returned`() =
        runTest {
            //GIVEN
            whenever(movieDetailDao.getMovieDetail(MOVIE_ID)).thenReturn(getMovieDetailModel())

            //WHEN
            val movieDetail = localMovieDetailSource.getMovieDetail(MOVIE_ID)

            //THEN
            assertNotNull(movieDetail)
        }

    @Test
    fun `GIVEN movie detail error WHEN getMovieDetail requested THEN movie detail is failure`() =
        runTest {
            //GIVEN
            whenever(movieDetailDao.getMovieDetail(MOVIE_ID)).thenReturn(null)

            //WHEN
            val movieDetail = localMovieDetailSource.getMovieDetail(MOVIE_ID)

            //THEN
            assertNull(movieDetail)
        }

    @Test
    fun `GIVEN add movie detail successfully WHEN addMovieDetail requested THEN movie detail is added`() =
        runTest {
            //Given
            whenever(movieDetailDao.getMovieDetail(MOVIE_ID)).thenReturn(getMovieDetailModel())

            //When
            movieDetailDao.addMovieDetail(getMovieDetailModel())
            val getMovieDetail = movieDetailDao.getMovieDetail(MOVIE_ID)

            //Then
            assertNotNull(getMovieDetail)
        }

    @Test
    fun `GIVEN add movie detail error WHEN addMovieDetail requested THEN movie detail is not added`() =
        runTest {
            //Given
            whenever(movieDetailDao.getMovieDetail(MOVIE_ID)).thenReturn(null)

            //When
            movieDetailDao.addMovieDetail(getMovieDetailModel())
            val getMovieDetail = movieDetailDao.getMovieDetail(MOVIE_ID)

            //Then
            assertNull(getMovieDetail)
        }
}