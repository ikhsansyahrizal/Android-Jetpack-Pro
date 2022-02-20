package com.dicoding.appfilm.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.vo.Resource

interface FIlmDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovies(movieId: String): LiveData<Resource<MovieEntity>>

    fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShows(tvShowId: String): LiveData<Resource<TvShowEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)

    fun getMovieFavorite(): LiveData<PagedList<MovieEntity>>

    fun getTvShowFavorite(): LiveData<PagedList<TvShowEntity>>

}