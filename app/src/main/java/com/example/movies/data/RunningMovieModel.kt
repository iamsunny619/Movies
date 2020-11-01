package com.example.movies.data


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RunningMovieModel(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int, // 1
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int, // 74
    @SerializedName("total_results")
    val totalResults: Int // 1476
) {
    @Keep
    data class Dates(
        @SerializedName("maximum")
        val maximum: String, // 2020-11-05
        @SerializedName("minimum")
        val minimum: String // 2020-09-18
    )

    @Keep
    data class Result(
        @SerializedName("adult")
        val adult: Boolean, // false
        @SerializedName("backdrop_path")
        val backdropPath: String, // /86L8wqGMDbwURPni2t7FQ0nDjsH.jpg
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("id")
        val id: Int, // 724989
        @SerializedName("original_language")
        val originalLanguage: String, // en
        @SerializedName("original_title")
        val originalTitle: String, // Hard Kill
        @SerializedName("overview")
        val overview: String, // The work of billionaire tech CEO Donovan Chalmers is so valuable that he hires mercenaries to protect it, and a terrorist group kidnaps his daughter just to get it.
        @SerializedName("popularity")
        val popularity: Double, // 2235.816
        @SerializedName("poster_path")
        val posterPath: String, // /ugZW8ocsrfgI95pnQ7wrmKDxIe.jpg
        @SerializedName("release_date")
        val releaseDate: String, // 2020-10-23
        @SerializedName("title")
        val title: String, // Hard Kill
        @SerializedName("video")
        val video: Boolean, // false
        @SerializedName("vote_average")
        val voteAverage: Double, // 4.5
        @SerializedName("vote_count")
        val voteCount: Int // 34
    )
}