package com.example.movies.data

import com.example.movies.ui.utils.AppConstant
import javax.inject.Inject

class RunningMovieRepository @Inject constructor(private val tmdbApi: TmdbApi) {

    suspend fun getPlayingMovie():NowPlayingModel {
        return tmdbApi.getRunningMovies(AppConstant.apiKey)
    }

}