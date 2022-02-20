package com.dicoding.appfilm.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity

class FavTvShowViewModel(private val mFilmRepository: FilmRepository): ViewModel() {

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> =
        mFilmRepository.getTvShowFavorite()

    fun setFavoriteTvShow(tvShow: TvShowEntity) {
        val newState = !tvShow.fav
        mFilmRepository.setTvShowFavorite(tvShow, newState)

    }

}