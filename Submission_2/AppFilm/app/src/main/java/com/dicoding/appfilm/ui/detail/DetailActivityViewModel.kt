package com.dicoding.appfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity

class DetailActivityViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private lateinit var movieId: String
    private lateinit var tvShowId: String

    fun setMovie(idMovie: String) {
        this.movieId = idMovie
    }

    fun setTvShow(idTvShow: String) {
        this.tvShowId = idTvShow
    }

    fun getMovieDetail(): LiveData<MovieEntity> = filmRepository.getDetailMovies(movieId)


    fun getTvShowDetail(): LiveData<TvShowEntity> = filmRepository.getDetailTvShows(tvShowId)




}