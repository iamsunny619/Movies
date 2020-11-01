package com.example.movies.ui.runningmovie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.movies.R
import com.example.movies.databinding.FragmentRunningMovieBinding
import com.example.movies.ui.runningmovie.viewmodel.RunningMovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunningMovieFragment : Fragment() {
    private lateinit var bind: FragmentRunningMovieBinding
    private val viewModel by viewModels<RunningMovieViewModel>()
    private lateinit var runningMovieaAdapter: RunningMovieaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_running_movie, container, false)
        viewSetUp()
        return bind.root
    }

    private fun viewSetUp() {
        bind.txtDummy.text = "im runnung movie fraGMEBT"
        setUpRecycler()
        bind.btnFInd.setOnClickListener {
            viewModel.getRunningData()
            viewModel.getRunningMovie.observe(viewLifecycleOwner) {
                Log.i("frag", it.toString())
                runningMovieaAdapter.items = it.results

            }
        }
    }

    private fun setUpRecycler() {
        runningMovieaAdapter = RunningMovieaAdapter(emptyList()) { _, _, item ->

        }
        bind.rvData.setHasFixedSize(true)
        bind.rvData.itemAnimator = DefaultItemAnimator()
        bind.rvData.adapter = runningMovieaAdapter
    }

}