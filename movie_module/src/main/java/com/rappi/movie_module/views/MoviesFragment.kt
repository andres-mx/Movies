package com.rappi.movie_module.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rappi.core_module.MovieDetailFromMovieRoute
import com.rappi.movie_module.R
import com.rappi.movie_module.databinding.FragmentMoviesBinding
import com.rappi.movie_module.utils.MovieUtils.FILTER_KEY_STRING
import com.rappi.movie_module.utils.MovieUtils.LANGUAGE_STRING
import com.rappi.movie_module.utils.MovieUtils.YEAR_STRING
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
        initView()
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
            movieAdapter = MovieAdapter(videoItemClick, filterClick)
            binding.videos.adapter = movieAdapter
            movieAdapter.submitList(movieViewState.movies)
        }
        is MovieViewState.MoviesFailure -> {
            showErrorView(movieViewState.error)
        }
        is MovieViewState.Idle -> {
            binding.shimmerLayout.startShimmer()
        }
        else -> {

        }
    }

    private fun initView() = with(binding) {
        trayAgainButton.setOnClickListener {
            viewModel.getMovies()
        }
    }

    private fun showErrorView(error: String) = with(binding) {
        errorLayout.visibility = View.VISIBLE
        errorDescriptionTextView.text = error
        videos.visibility = View.GONE
        shimmerLayout.stopShimmer()
        shimmerLayout.visibility = View.GONE
    }

    private val videoItemClick: (Int) -> Unit = { id ->
        movieDetailFromMovieRoute.show(id, findNavController())
    }

    private val filterClick: (Int) -> Unit = { id ->
        findNavController().currentBackStackEntry?.savedStateHandle?.remove<String>(
            FILTER_KEY_STRING
        )
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<String>(
            FILTER_KEY_STRING
        )
            ?.observe(viewLifecycleOwner) { filterValue ->
                goToFilter(id, filterValue)
            }
        findNavController().navigate(
            R.id.action_movieFragment_to_filterOptionBottomSheet,
            getFilterArgument(id)
        )
    }

    private fun showRecyclerView() = with(binding) {
        shimmerLayout.stopShimmer()
        shimmerLayout.visibility = View.GONE
        errorLayout.visibility = View.GONE
        videos.visibility = View.VISIBLE
    }

    private fun goToFilter(id: Int, filterValue: String) {
        if (id == 0) {
            viewModel.getRecommendedByLanguage(filterValue)
        } else {
            viewModel.getRecommendedByYear(filterValue)
        }
    }

    private fun getFilterArgument(id: Int): Bundle = if (id == 0) {
        bundleOf(LANGUAGE_STRING to LANGUAGE_STRING)
    } else {
        bundleOf(YEAR_STRING to YEAR_STRING)
    }
}