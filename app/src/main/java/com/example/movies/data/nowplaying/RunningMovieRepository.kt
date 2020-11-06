package com.example.movies.data.nowplaying

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.movies.data.TmdbApi
import com.example.movies.data.nowplaying.source.MoviePagingSource
import javax.inject.Inject

class RunningMovieRepository @Inject constructor(private val tmdbApi: TmdbApi) {

    fun getMovie(apiKey: String) = Pager(config = PagingConfig(
        pageSize = 1),
        pagingSourceFactory = { MoviePagingSource(tmdbApi, apiKey) }
    ).liveData

}