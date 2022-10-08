package com.rappi.movie_module.utils

import com.rappi.movie_module.BuildConfig
import com.rappi.movie_module.view_models.MoviesDataToConvert
import com.rappi.movie_module.views.movies.MovieViewData
import com.rappi.movie_module.views.movies.MoviesData
import com.rappi.movie_module.views.movies.RecommendedViewData
import com.rappi.movie_module.views.movies.VideosViewData

object MovieUtils {
    fun getVideosData(moviesDataToConvert: MoviesDataToConvert): List<MoviesData> {
        val moviesData = mutableListOf<MoviesData>()
        if (moviesDataToConvert.upComings.isEmpty() && moviesDataToConvert.topRatedList.isEmpty()) return moviesData
        val upcomingVideos = mutableListOf<VideosViewData>()
        moviesDataToConvert.upComings.map { upcoming ->
            upcomingVideos.add(
                VideosViewData(
                    upcoming.movieId,
                    BuildConfig.URLIMAGES + upcoming.image
                )
            )
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Próximos estrenos", upcomingVideos)))

        val topRatedVideos = mutableListOf<VideosViewData>()
        moviesDataToConvert.topRatedList.map { topRated ->
            topRatedVideos.add(
                VideosViewData(
                    topRated.movieId,
                    BuildConfig.URLIMAGES + topRated.image
                )
            )
        }

        moviesData.add(MoviesData.MoviesSection(MovieViewData("Tendencia", topRatedVideos)))


        val recommendedVideos = mutableListOf<VideosViewData>()
        moviesDataToConvert.recommendedList.map { recommended ->
            recommendedVideos.add(
                VideosViewData(
                    recommended.movieId,
                    BuildConfig.URLIMAGES + recommended.image
                )
            )
        }

        moviesData.add(
            MoviesData.RecommendedSection(
                RecommendedViewData(
                    hashMapOf(
                        Pair(0, "Idioma: ${moviesDataToConvert.language}"),
                        Pair(1, "Año: ${moviesDataToConvert.year}")
                    ),
                    recommendedVideos
                )
            )
        )
        return moviesData
    }
}