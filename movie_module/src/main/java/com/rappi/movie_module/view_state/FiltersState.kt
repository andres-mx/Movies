package com.rappi.movie_module.view_state

import com.rappi.movie_module.views.movies.FilterOptionViewData

sealed class FiltersState {
    object Idle : FiltersState()
    data class FiltersSuccessful(val filters: List<FilterOptionViewData>) : FiltersState()
    object FilterFailure : FiltersState()
}
