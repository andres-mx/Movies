package com.rappi.trailer_module.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.rappi.trailer_module.databinding.FragmentTrailerBinding
import com.rappi.trailer_module.view_models.TrailerViewModel
import com.rappi.trailer_module.view_state.TrailerViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrailerFragment : Fragment() {
    private val viewModel: TrailerViewModel by viewModels()
    private var _binding: FragmentTrailerBinding? = null
    private val binding: FragmentTrailerBinding get() = _binding!!
    private var movieId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrailerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpArguments(arguments)
        setUpObserve()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setUpArguments(arguments: Bundle?) {
        movieId = arguments?.getInt("id") ?: 0
    }

    private fun setUpObserve() {
        viewModel.trailerViewState.observe(viewLifecycleOwner) { trailerViewState ->
            renderUi(trailerViewState)
        }
    }

    private fun renderUi(trailerViewState: TrailerViewState?) = when (trailerViewState) {
        is TrailerViewState.TrailerSuccessful -> {}
        is TrailerViewState.TrailerFailure -> {}
        is TrailerViewState.Idle -> {}
        else -> {}
    }
}