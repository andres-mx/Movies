package com.rappi.detail_module.views

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.rappi.core_module.MovieDetailFromMovieRoute
import com.rappi.detail_module.R
import javax.inject.Inject

class MovieDetailFromMovieRouteImpl @Inject constructor() : MovieDetailFromMovieRoute {
    override fun show(id: Int, navController: NavController) {
        navController.navigate(R.id.movie_detail, bundleOf("id" to id))
    }
}