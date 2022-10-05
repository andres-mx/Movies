package com.rappi.trailer_module.views

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.rappi.core_module.TrailerFromMovieDetailRoute
import com.rappi.trailer_module.R
import javax.inject.Inject

class TrailerFromMovieDetailRouteImpl @Inject constructor() : TrailerFromMovieDetailRoute {
    override fun show(id: Int, navController: NavController) {
        navController.navigate(R.id.trailer_graph, bundleOf("id" to id))
    }
}