package com.dicoding.appfilm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.vo.Resource

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovie() : LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getAllMovies()
}