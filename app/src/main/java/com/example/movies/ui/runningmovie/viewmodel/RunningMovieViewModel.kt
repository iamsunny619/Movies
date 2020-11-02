package com.example.movies.ui.runningmovie.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.data.nowplaying.NowPlayingModel
import com.example.movies.data.nowplaying.RunningMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RunningMovieViewModel @ViewModelInject constructor(
    private val runningMovieRepository: RunningMovieRepository
) : ViewModel() {

    private val _getRunningMovie = MutableLiveData<NowPlayingModel>()
    val getRunningMovie: LiveData<NowPlayingModel> = _getRunningMovie

    private val _progressLiveData = MutableLiveData<Boolean?>()
    val progressLiveData: LiveData<Boolean?> = _progressLiveData

    fun getRunningData() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                _progressLiveData.postValue(true)
                runningMovieRepository.getPlayingMovie()
            }.onSuccess {
                _progressLiveData.postValue(false)
                _getRunningMovie.postValue(it)
                Log.d("viewmodel", it.toString())
            }.onFailure {
                Log.d("viewmodel", it.toString())
                _progressLiveData.postValue(false)
            }
        }

    }

}