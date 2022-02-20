package com.dicoding.appfilm.ui.tvShow

import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.FilmEntity
import com.dicoding.appfilm.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<FilmEntity> = DataDummy.generateDummyTvShow()
}