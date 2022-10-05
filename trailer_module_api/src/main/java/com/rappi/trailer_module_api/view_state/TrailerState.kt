package com.rappi.trailer_module_api.view_state

import androidx.annotation.StringRes
import com.rappi.trailer_module_api.data.Trailer

sealed class TrailerState {
    object Idle : TrailerState()
    data class TrailerSuccessful(val trailer: Trailer) : TrailerState()
    object TrailerEmpty : TrailerState()
    data class TrailerFailure(@StringRes val error: Int) : TrailerState()
}