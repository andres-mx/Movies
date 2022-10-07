package com.rappi.detail_module.data

import com.rappi.detail_module_api.data.MovieDetail
import com.rappi.detail_module_api.data.MovieDetailApi
import javax.inject.Inject

class MovieDetailApiImpl @Inject constructor(private val movieDetailService: MovieDetailService) :
    MovieDetailApi {
    override suspend fun getDetailMovie(id: Int): MovieDetail? {
        val detailResponse = movieDetailService.getMovieDetail(movieId = id)
        return detailResponse?.toDetailMovie()
    }
}

private fun DetailMovieResponse.toDetailMovie(): MovieDetail? = if (this.id == 0) {
    null
} else {
    MovieDetail(
        movieId = this.id,
        imageUrl = this.poster_path.orEmpty(),
        year = this.release_date.orEmpty(),
        language = this.original_language.orEmpty(),
        title = this.title.orEmpty(),
        originalTitle = this.original_title.orEmpty(),
        description = this.overview.orEmpty(),
        rating = String.format("%.2f", vote_average)
    )
}

