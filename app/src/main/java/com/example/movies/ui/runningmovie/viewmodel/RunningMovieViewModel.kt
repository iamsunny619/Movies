package com.example.movies.ui.runningmovie.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import com.example.movies.data.RunningMovieRepository

class RunningMovieViewModel @ViewModelInject constructor(
    private val runningMovieRepository: RunningMovieRepository
) {
}