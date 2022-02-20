package com.dicoding.appfilm.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity

class FavMovieViewModel(private val mFilmRepository: FilmRepository): ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> =
        mFilmRepository.getMovieFavorite()

    fun setFavoriteMovie(movie: MovieEntity) {
        val newState = !movie.fav
        mFilmRepository.setMovieFavorite(movie, newState)

    }
}