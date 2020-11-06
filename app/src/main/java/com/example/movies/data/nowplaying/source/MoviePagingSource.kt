package com.example.movies.data.nowplaying.source

import android.util.Log
import androidx.paging.PagingSource
import com.example.movies.data.TmdbApi
import com.example.movies.data.nowplaying.NowPlayingModel
import com.example.movies.ui.utils.AppConstant
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(private val tmdbApi: TmdbApi, private val apiKey: String) :
    PagingSource<Int, NowPlayingModel.Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NowPlayingModel.Result> {
        val position = params.key ?: AppConstant.TmdpStartingPageIndex
        return try {
            val response = tmdbApi.getRunningMovies(apiKey,"en-US", position)
            val data = response.results

            LoadResult.Page(
                data = data,
                prevKey = if (position == AppConstant.TmdpStartingPageIndex) null else (position-1),
                nextKey = if (data.isEmpty()) null else (position+1)
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}