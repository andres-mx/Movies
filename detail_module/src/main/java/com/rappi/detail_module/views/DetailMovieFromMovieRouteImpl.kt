package com.rappi.detail_module.views

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.rappi.core_module.DetailMovieFromMovieRoute
import com.rappi.detail_module.R
import javax.inject.Inject

class DetailMovieFromMovieRouteImpl @Inject constructor() : DetailMovieFromMovieRoute {
    override fun show(any: Any, navController: NavController) {
        navController.navigate(R.id.movie_detail, bundleOf())
    }
}