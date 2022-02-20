package com.dicoding.appfilm.ui.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getAllTvShow()
}