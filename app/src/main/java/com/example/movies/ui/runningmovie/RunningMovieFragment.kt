package com.example.movies.ui.runningmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movies.R
import com.example.movies.databinding.FragmentRunningMovieBinding
import com.example.movies.ui.runningmovie.adapter.RunningMoviePagingAdapter
import com.example.movies.ui.runningmovie.viewmodel.RunningMovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RunningMovieFragment : Fragment() {
    private lateinit var bind: FragmentRunningMovieBinding
    private val viewModel by viewModels<RunningMovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_running_movie, container, false)
        setUp()
        return bind.root
    }

    private fun setUp() {
        val adapter = RunningMoviePagingAdapter()
        bind.apply {
            rvData.setHasFixedSize(true)
            rvData.adapter = adapter
        }
        lifecycleScope.launch {
            viewModel.data.observe(viewLifecycleOwner) {
                Log.i("frag", it.toString())
                adapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }

}