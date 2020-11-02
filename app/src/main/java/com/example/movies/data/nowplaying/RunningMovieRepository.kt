package com.example.movies.data.nowplaying

import com.example.movies.data.TmdbApi
import com.example.movies.ui.utils.AppConstant
import javax.inject.Inject

class RunningMovieRepository @Inject constructor(private val tmdbApi: TmdbApi) {

    suspend fun getPlayingMovie(): NowPlayingModel {
        return tmdbApi.getRunningMovies(AppConstant.apiKey)
    }


}