package com.dicoding.appfilm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getMovie() : LiveData<List<MovieEntity>> = filmRepository.getAllMovies()
}