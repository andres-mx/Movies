package com.rappi.trailer_module

import com.rappi.trailer_module.TrailerData.getTrailer
import com.rappi.trailer_module.domain.GetTrailerUseCaseImpl
import com.rappi.trailer_module_api.domain.GetTrailerUseCase
import com.rappi.trailer_module_api.repository.TrailerRepository
import com.rappi.trailer_module_api.view_state.TrailerState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class GetTrailerUseCaseImplUnitTest {
    private lateinit var getTrailerUseCase: GetTrailerUseCase
    private val repository: TrailerRepository = mock()

    @Before
    fun setUp() {
        getTrailerUseCase = GetTrailerUseCaseImpl(repository)
    }

    @Test
    fun `GIVEN trailer by id WHEN GetTrailerUseCase requested THEN Trailer is returned`() =
        runTest {
            //Given
            whenever(repository.getTrailer(1)).thenReturn(getTrailer())

            //When
            val trailer = getTrailerUseCase(1)

            //Then
            Assert.assertTrue(trailer is TrailerState.TrailerSuccessful)
        }

    @Test
    fun `GIVEN trailer by id WHEN GetTrailerUseCase requested THEN Trailer is null returned`() =
        runTest {
            //Given
            whenever(repository.getTrailer(1)).thenReturn(null)

            //When
            val movieDetail = getTrailerUseCase(1)

            //Then
            Assert.assertTrue(movieDetail is TrailerState.TrailerEmpty)
        }
}