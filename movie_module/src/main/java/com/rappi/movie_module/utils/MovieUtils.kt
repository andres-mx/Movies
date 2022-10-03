package com.rappi.movie_module.utils

import com.rappi.movie_module.BuildConfig
import com.rappi.movie_module.views.movies.MovieViewData
import com.rappi.movie_module.views.movies.MoviesData
import com.rappi.movie_module.views.movies.VideosViewData
import com.rappi.movie_module_api.data.Movie

object MovieUtils {
    /*fun getVideosData(upcomingList: List<Movie>, topRatedList: List<Movie>): List<VideosData> {
        val videosData = mutableListOf<VideosData>()
        videosData.add(VideosData.HeaderSection(HeaderViewData("Próximos estrenos")))
        upcomingList.map { upcoming ->
            videosData.add(
                VideosData.VideosSection(
                    VideosViewData(
                        upcoming.movieId,
                        BuildConfig.URLIMAGES + upcoming.image
                    )
                )
            )
        }
        videosData.add(VideosData.HeaderSection(HeaderViewData("Tendencia")))
        topRatedList.map { topRated ->
            videosData.add(
                VideosData.VideosSection(
                    VideosViewData(
                        topRated.movieId,
                        BuildConfig.URLIMAGES + topRated.image
                    )
                )
            )
        }

        return videosData
    }*/

    fun getVideosData(upcomingList: List<Movie>, topRatedList: List<Movie>): List<MoviesData> {
        val moviesData = mutableListOf<MoviesData>()
        val videos = mutableListOf<VideosViewData>()
        upcomingList.map { upcoming ->
            videos.add(VideosViewData(upcoming.movieId, BuildConfig.URLIMAGES + upcoming.image))
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Próximos estrenos", videos)))
        videos.clear()

        topRatedList.map { topRated ->
            videos.add(VideosViewData(topRated.movieId, BuildConfig.URLIMAGES + topRated.image))
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Tendencia", videos)))

        return moviesData
    }
}