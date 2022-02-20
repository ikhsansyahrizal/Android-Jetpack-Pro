package com.dicoding.appfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.vo.Resource

class DetailActivityViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private val movieId = MutableLiveData<String>()
    private val tvShowId = MutableLiveData<String>()

    fun setMovie(idMovie: String) {
        this.movieId.value = idMovie
    }

    fun setTvShow(idTvShow: String) {
        this.tvShowId.value = idTvShow
    }

    var movie: LiveData<Resource<MovieEntity>> = Transformations.switchMap(movieId) { idMovie ->
        filmRepository.getDetailMovies(idMovie)
    }

    var tvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId) { idTvShow ->
        filmRepository.getDetailTvShows(idTvShow)
    }


    fun setFavorite() {

        val movieResource = movie.value
        val tvShowResource = tvShow.value

        if (movieResource != null) {
            val movieWithData = movieResource.data

            if (movieWithData != null) {
                val newState = !movieWithData.fav
                filmRepository.setMovieFavorite(movieWithData, newState)
            }
        }

        if (tvShowResource != null) {
            val tvShowWithData = tvShowResource.data

            if (tvShowWithData != null) {
                val newState = !tvShowWithData.fav
                filmRepository.setTvShowFavorite(tvShowWithData, newState)
            }
        }


    }



}