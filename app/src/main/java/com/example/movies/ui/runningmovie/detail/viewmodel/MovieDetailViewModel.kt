package com.example.movies.ui.runningmovie.detail.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.BuildConfig
import com.example.movies.data.moviedetails.MovieDetailModel
import com.example.movies.data.moviedetails.MovieDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel
@ViewModelInject constructor
    (
    private val movieDetailRepository:
    MovieDetailRepository
) :
    ViewModel() {

    private val _movieDetail = MutableLiveData<MovieDetailModel>()
    val movieDetail: LiveData<MovieDetailModel> = _movieDetail

    private val _progress = MutableLiveData<Boolean?>()
    val progress: LiveData<Boolean?> = _progress

    fun getMovieDetail(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                _progress.postValue(true)
                movieDetailRepository.getMovieDetail(movieId, BuildConfig.TMDB_ACCESS_KEY)
            }.onSuccess {
                Log.d("viewmodel2", it.toString())
                _progress.postValue(false)
                _movieDetail.postValue(it)
            }.onFailure {
                _progress.postValue(false)
                Log.d("viewmodel2", it.toString())
            }
        }
    }
}