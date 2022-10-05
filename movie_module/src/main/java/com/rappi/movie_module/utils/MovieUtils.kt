package com.rappi.movie_module.utils

import com.rappi.movie_module.BuildConfig
import com.rappi.movie_module.views.movies.MovieViewData
import com.rappi.movie_module.views.movies.MoviesData
import com.rappi.movie_module.views.movies.VideosViewData
import com.rappi.movie_module_api.data.Movie

object MovieUtils {
    fun getVideosData(upcomingList: List<Movie>, topRatedList: List<Movie>): List<MoviesData> {
        val moviesData = mutableListOf<MoviesData>()
        if (upcomingList.isEmpty() && topRatedList.isEmpty()) return moviesData
        val upcomingVideos = mutableListOf<VideosViewData>()
        upcomingList.map { upcoming ->
            upcomingVideos.add(
                VideosViewData(
                    upcoming.movieId,
                    BuildConfig.URLIMAGES + upcoming.image
                )
            )
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Próximos estrenos", upcomingVideos)))

        val topRatedVideos = mutableListOf<VideosViewData>()
        topRatedList.map { topRated ->
            topRatedVideos.add(
                VideosViewData(
                    topRated.movieId,
                    BuildConfig.URLIMAGES + topRated.image
                )
            )
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Tendencia", topRatedVideos)))

        return moviesData
    }
}