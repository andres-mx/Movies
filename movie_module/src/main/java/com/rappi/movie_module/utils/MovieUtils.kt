package com.rappi.movie_module.utils

import com.rappi.movie_module.BuildConfig
import com.rappi.movie_module.data.Result
import com.rappi.movie_module.view_models.MoviesDataToConvert
import com.rappi.movie_module.views.movies.*
import com.rappi.movie_module_api.data.Movie
import com.rappi.movie_module_api.data.MovieType
import com.rappi.movie_module_api.database.MovieModel

object MovieUtils {
    const val ERROR_MOVIES_SERVICE = "Error al consumir el servicio de películas"
    const val FILTER_KEY_STRING = "filterKey"
    const val LANGUAGE_STRING = "language"
    const val YEAR_STRING = "year"
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

    fun getFilters(
        languagesResponse: List<String>,
        filterSelected: String
    ): List<FilterOptionViewData> {
        val filters = mutableListOf<FilterOptionViewData>()
        languagesResponse.map {
            if (it.uppercase() == filterSelected.uppercase()) {
                filters.add(FilterOptionViewData(it, true))
            } else {
                filters.add(FilterOptionViewData(it, false))
            }
        }
        return filters
    }

    fun Movie.toMovieModel(type: MovieType) = MovieModel(
        movieId = this.movieId,
        image = this.image,
        language = this.language.orEmpty(),
        year = this.year.orEmpty(),
        type = type.name
    )

    fun MovieModel.toMovie() = Movie(
        movieId = this.movieId,
        image = this.image,
        language = this.language,
        year = this.year,
        type = this.type
    )


    fun Result.toMovie(): Movie =
        Movie(
            movieId = this.id ?: 0,
            image = this.poster_path.orEmpty(),
            language = this.original_language,
            year = this.release_date?.substring(0, 4)
        )

}