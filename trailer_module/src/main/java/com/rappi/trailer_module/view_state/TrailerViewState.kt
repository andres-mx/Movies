package com.rappi.trailer_module.view_state

sealed class TrailerViewState {
    object Idle : TrailerViewState()
    data class TrailerSuccessful(val trailer: String) : TrailerViewState()
    data class TrailerFailure(val error: String) : TrailerViewState()
}
