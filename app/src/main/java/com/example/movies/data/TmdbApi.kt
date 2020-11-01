package com.example.movies.data

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/now_playing")
    suspend fun getRunningMovies(@Query("api_key") api_key: String): RunningMovieModel

}