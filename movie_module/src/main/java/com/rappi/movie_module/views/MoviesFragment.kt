package com.rappi.movie_module.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rappi.core_module.MovieDetailFromMovieRoute
import com.rappi.movie_module.databinding.FragmentMoviesBinding
import com.rappi.movie_module.view_models.MoviesViewModel
import com.rappi.movie_module.view_state.MovieViewState
import com.rappi.movie_module.views.movies.MovieAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private val viewModel: MoviesViewModel by viewModels()
    private var _binding: FragmentMoviesBinding? = null
    private val binding: FragmentMoviesBinding get() = _binding!!
    private lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieDetailFromMovieRoute: MovieDetailFromMovieRoute

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserve()
        viewModel.getMovies()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpObserve() {
        viewModel.moviesViewState.observe(viewLifecycleOwner) { movieViewState ->
            renderUi(movieViewState)
        }
    }

    private fun renderUi(movieViewState: MovieViewState?) = when (movieViewState) {
        is MovieViewState.MoviesSuccessful -> {
            showRecyclerView()
            movieAdapter = MovieAdapter(movieViewState.movies, videoItemClick)
            binding.videos.adapter = movieAdapter
        }
        is MovieViewState.MoviesFailure -> {

        }
        is MovieViewState.Idle -> {
            binding.shimmerLayout.startShimmer()
        }
        else -> {

        }
    }

    private val videoItemClick: (Int) -> Unit = { id ->
        movieDetailFromMovieRoute.show(id, findNavController())
    }

    private fun showRecyclerView() {
        binding.shimmerLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
        binding.videos.visibility = View.VISIBLE
    }
}