package com.rappi.trailer_module

import com.rappi.trailer_module.data.TrailerApiImpl
import com.rappi.trailer_module.data.TrailerResponse
import com.rappi.trailer_module.data.TrailerService
import com.rappi.trailer_module_api.data.TrailerApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class TrailerApiImplUnitTest {
    private lateinit var trailerApi: TrailerApi
    private var services: TrailerService = mock()

    @Before
    fun setUp() {
        services = mock(TrailerService::class.java)
        trailerApi = TrailerApiImpl(services)
    }

    @Test
    fun `GIVEN trailer successfully WHEN trailer requested THEN Trailer is returned`() =
        runTest {
            //Given
            whenever(services.getTrailer(movieId = 70)).thenReturn(TrailerResponse(id = 70))

            //When
            val trailerResult = trailerApi.getTrailer(70)

            //Then
            Assert.assertNotNull(trailerResult)
        }

    @Test
    fun `GIVEN trailer successfully WHEN trailer requested THEN movieId is null`() =
        runTest {
            //Given
            whenever(services.getTrailer(movieId = 70)).thenReturn(TrailerResponse(id = null))

            //When
            val trailerResult = trailerApi.getTrailer(70)

            //Then
            Assert.assertNull(trailerResult?.movieId)
        }

    @Test
    fun `GIVEN trailer successfully WHEN trailer requested THEN Trailer is null`() =
        runTest {
            //Given
            whenever(services.getTrailer(movieId = 70)).thenReturn(null)

            //When
            val trailerResult = trailerApi.getTrailer(70)

            //Then
            Assert.assertNull(trailerResult?.movieId)
        }
}