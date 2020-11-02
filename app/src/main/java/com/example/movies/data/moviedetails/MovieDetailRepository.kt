package com.example.movies.data.moviedetails

import com.example.movies.data.TmdbApi
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(private val tmdbApi: TmdbApi) {

    suspend fun getMovieDetail(movieId: Int, apiKey: String): MovieDetailModel {
        return tmdbApi.getMovieDetails(movieId, apiKey)
    }
}