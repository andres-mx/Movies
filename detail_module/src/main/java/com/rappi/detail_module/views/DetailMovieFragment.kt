package com.rappi.detail_module.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.rappi.core_module.TrailerFromMovieDetailRoute
import com.rappi.detail_module.databinding.FragmentDetailMovieBinding
import com.rappi.detail_module.view_models.MovieDetailViewModel
import com.rappi.detail_module.view_state.MovieDetailViewState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailMovieFragment : Fragment() {
    private val viewModel: MovieDetailViewModel by viewModels()
    private var _binding: FragmentDetailMovieBinding? = null
    private val binding: FragmentDetailMovieBinding get() = _binding!!
    private var movieId: Int = 0

    @Inject
    lateinit var trailerFromMovieDetailRoute: TrailerFromMovieDetailRoute

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
        setUpArguments(arguments)
        setUpObserve()
        viewModel.getMovieDetail(movieId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpUi() {
        _binding?.trailerButton?.setOnClickListener {
            trailerFromMovieDetailRoute.show(movieId, findNavController())
        }
    }

    private fun setUpArguments(arguments: Bundle?) {
        movieId = arguments?.getInt("id") ?: 0
    }

    private fun setUpObserve() {
        viewModel.movieDetailViewState.observe(viewLifecycleOwner) { movieDetailViewState ->
            renderUi(movieDetailViewState)
        }
    }

    private fun fillUi(movieDetailViewData: MovieDetailViewData) = with(binding) {
        movieImage.load(movieDetailViewData.imageUrl) {
            crossfade(true)
            placeholder(android.R.drawable.btn_radio)
            error(android.R.drawable.stat_notify_error)
        }
        titleMovieTextView.text = movieDetailViewData.title
        yearButton.text = movieDetailViewData.year
        languageButton.text = movieDetailViewData.language
        ratingButton.text = movieDetailViewData.rating.toString()
        genderTextView.text = ""
        originalTitleTextView.text = movieDetailViewData.originalTitle
        descriptionTextView.text = movieDetailViewData.description
    }

    private fun renderUi(movieDetailViewState: MovieDetailViewState?) =
        when (movieDetailViewState) {
            is MovieDetailViewState.MovieDetailSuccessful -> {
                fillUi(movieDetailViewState.movieDetailViewData)
            }
            is MovieDetailViewState.MovieDetailFailure -> {}
            is MovieDetailViewState.Idle -> {
            }
            else -> {}
        }
}