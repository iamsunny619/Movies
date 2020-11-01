package com.example.movies.di

import com.example.movies.data.RunningMovieRepository
import com.example.movies.data.TmdbApi
import com.example.movies.ui.utils.AppConstant
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(AppConstant.BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideTmdbAPi(retrofit: Retrofit): TmdbApi = retrofit.create(TmdbApi::class.java)


}