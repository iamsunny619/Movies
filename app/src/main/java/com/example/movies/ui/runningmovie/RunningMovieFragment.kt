package com.example.movies.ui.runningmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.movies.R
import com.example.movies.databinding.FragmentRunningMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunningMovieFragment : Fragment() {
    private lateinit var bind: FragmentRunningMovieBinding
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
    }

}