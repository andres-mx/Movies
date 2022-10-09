package com.rappi.detail_module

import com.rappi.detail_module.DetailData.MOVIE_ID
import com.rappi.detail_module.DetailData.getDetailMovie
import com.rappi.detail_module.repository.MovieDetailRepositoryImpl
import com.rappi.detail_module_api.data.LocalMovieDetailSource
import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.data.MovieDetailApi
import com.rappi.detail_module_api.repository.DetailRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MovieDetailRepositoryImplUnitTest {
    private val movieDetailApi: MovieDetailApi = mock()
    private val localMovieDetailSource: LocalMovieDetailSource = mock()
    private lateinit var movieDetailRepository: DetailRepository

    @Before
    fun setUp() {
        movieDetailRepository = MovieDetailRepositoryImpl(movieDetailApi, localMovieDetailSource)
    }

    @Test
    fun `GIVEN movie detail successfully WHEN getDetailMovie requested THEN MovieDetail is returned`() =
        runTest {
            //Given
            whenever(movieDetailApi.getDetailMovie(MOVIE_ID)).thenReturn(getDetailMovie())

            //When
            val movieDetail = movieDetailRepository.getDetailMovie(MOVIE_ID)

            //Then
            Assert.assertNotNull(movieDetail)
        }
}