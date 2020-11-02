package com.example.movies.data

import com.example.movies.data.moviedetails.MovieDetailModel
import com.example.movies.data.nowplaying.NowPlayingModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {

    @GET("movie/now_playing")
    suspend fun getRunningMovies(@Query("api_key") api_key: String): NowPlayingModel

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String
    ): MovieDetailModel

}