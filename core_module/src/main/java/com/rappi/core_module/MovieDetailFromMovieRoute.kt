package com.rappi.core_module

import androidx.navigation.NavController

interface MovieDetailFromMovieRoute {
    fun show(id: Int, navController: NavController)
}