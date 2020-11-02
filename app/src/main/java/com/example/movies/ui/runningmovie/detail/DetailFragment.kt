package com.example.movies.ui.runningmovie.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movies.R
import com.example.movies.databinding.FragmentDetailBinding
import com.example.movies.ui.runningmovie.detail.viewmodel.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var bind: FragmentDetailBinding
    private var movieId: String? = null
    private val viewModel by viewModels<MovieDetailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        initData()
        viewSetUp()
        viewModel.progress.observe(viewLifecycleOwner) {
            if (it!!) {
                bind.progressBar.visibility = View.VISIBLE
                Log.i("Tprogress", it.toString())
            } else {
                bind.progressBar.visibility = View.INVISIBLE
                Log.i("Fprogress", it.toString())
            }
        }
        return bind.root
    }

    private fun initData() {
        movieId = arguments?.getString("movieId")
        Log.i("movieId", movieId.toString())
        viewModel.getMovieDetail(movieId!!.toInt())
    }

    private fun viewSetUp() {
        viewModel.movieDetail.observe(viewLifecycleOwner) {
            bind.txtMovieDetail.text = it.originalTitle
            bind.txtGenere.text = it.status
        }
    }
}