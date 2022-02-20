package com.dicoding.appfilm.ui.movie

import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.FilmEntity
import com.dicoding.appfilm.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie() : List<FilmEntity> = DataDummy.generateDummyMovies()
}