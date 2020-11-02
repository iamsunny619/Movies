package com.example.movies.data.moviedetails


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class MovieDetailModel(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("backdrop_path")
    val backdropPath: String, // /xoqr4dMbRJnzuhsWDF3XNHQwJ9x.jpg
    @SerializedName("belongs_to_collection")
    val belongsToCollection: Any?, // null
    @SerializedName("budget")
    val budget: Int, // 0
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("homepage")
    val homepage: String, // https://kimetsu.com/anime/movie/mugenressyahen/
    @SerializedName("id")
    val id: Int, // 635302
    @SerializedName("imdb_id")
    val imdbId: String, // tt11032374
    @SerializedName("original_language")
    val originalLanguage: String, // ja
    @SerializedName("original_title")
    val originalTitle: String, // 劇場版「鬼滅の刃」無限列車編
    @SerializedName("overview")
    val overview: String, // Tanjirō Kamado, joined with Inosuke Hashibira, a boy raised by boars who wears a boar's head, and Zenitsu Agatsuma, a scared boy who reveals his true power when he sleeps, boards the Infinity Train on a new mission with the Fire Hashira, Kyōjurō Rengoku, to defeat a demon who has been tormenting the people and killing the demon slayers who oppose it!
    @SerializedName("popularity")
    val popularity: Double, // 868.519
    @SerializedName("poster_path")
    val posterPath: String, // /qfLpiXGV93x8EnZIjmuyO6qXBMx.jpg
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName("release_date")
    val releaseDate: String, // 2020-10-16
    @SerializedName("revenue")
    val revenue: Int, // 102000000
    @SerializedName("runtime")
    val runtime: Int, // 117
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName("status")
    val status: String, // Released
    @SerializedName("tagline")
    val tagline: String, // With your blade, bring an end to the nightmare.
    @SerializedName("title")
    val title: String, // Demon Slayer: Kimetsu no Yaiba - The Movie: Mugen Train
    @SerializedName("video")
    val video: Boolean, // false
    @SerializedName("vote_average")
    val voteAverage: Double, // 7.2
    @SerializedName("vote_count")
    val voteCount: Int // 28
) {
    @Keep
    data class Genre(
        @SerializedName("id")
        val id: Int, // 16
        @SerializedName("name")
        val name: String // Animation
    )

    @Keep
    data class ProductionCompany(
        @SerializedName("id")
        val id: Int, // 5887
        @SerializedName("logo_path")
        val logoPath: String, // /m6FEqz8rQECnmfjEwjNhNAlmhCJ.png
        @SerializedName("name")
        val name: String, // ufotable
        @SerializedName("origin_country")
        val originCountry: String // JP
    )

    @Keep
    data class ProductionCountry(
        @SerializedName("iso_3166_1")
        val iso31661: String, // JP
        @SerializedName("name")
        val name: String // Japan
    )

    @Keep
    data class SpokenLanguage(
        @SerializedName("iso_639_1")
        val iso6391: String, // ja
        @SerializedName("name")
        val name: String // 日本語
    )
}