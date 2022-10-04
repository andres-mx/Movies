package com.rappi.detail_module.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rappi.detail_module.R
import com.rappi.detail_module.databinding.FragmentDetailMovieBinding
import com.rappi.detail_module.view_models.MovieDetailViewModel
import com.rappi.detail_module.view_state.MovieDetailViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieFragment : Fragment() {
    private val viewModel: MovieDetailViewModel by viewModels()
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding: FragmentDetailMovieBinding get() = _binding!!
    private var movieId: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpArguments(arguments)
        setUpObserve()
        viewModel.getMovieDetail(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpArguments(arguments: Bundle?) {
        movieId = arguments?.getInt("id") ?: 0
    }

    private fun setUpObserve() {
        viewModel.movieDetailViewState.observe(viewLifecycleOwner) { movieDetailViewState ->
            renderUi(movieDetailViewState)
        }
    }

    private fun renderUi(movieDetailViewState: MovieDetailViewState?) =
        when (movieDetailViewState) {
            is MovieDetailViewState.MovieDetailSuccessful -> {}
            is MovieDetailViewState.MovieDetailFailure -> {}
            is MovieDetailViewState.Idle -> {}
            else -> {}
        }
}