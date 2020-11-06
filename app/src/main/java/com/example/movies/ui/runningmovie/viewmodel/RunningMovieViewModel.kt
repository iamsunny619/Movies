package com.example.movies.ui.runningmovie.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.movies.data.nowplaying.NowPlayingModel
import com.example.movies.data.nowplaying.RunningMovieRepository
import com.example.movies.ui.utils.AppConstant

class RunningMovieViewModel @ViewModelInject constructor(
    private val runningMovieRepository: RunningMovieRepository
) : ViewModel() {

    val data = runningMovieRepository.getMovie(AppConstant.apiKey)

}
