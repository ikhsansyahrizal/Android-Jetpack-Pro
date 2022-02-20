package com.dicoding.appfilm.data.source

import androidx.lifecycle.LiveData
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity

interface FIlmDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getDetailMovies(movieId: String): LiveData<MovieEntity>

    fun getAllTvShow(): LiveData<List<TvShowEntity>>

    fun getDetailTvShows(tvShowId: String): LiveData<TvShowEntity>

}