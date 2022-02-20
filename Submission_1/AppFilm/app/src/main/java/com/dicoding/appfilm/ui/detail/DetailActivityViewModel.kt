package com.dicoding.appfilm.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.appfilm.data.FilmEntity
import com.dicoding.appfilm.utils.DataDummy

class DetailActivityViewModel: ViewModel() {

    private lateinit var titleMovie : String
    private lateinit var titletvShow : String

    private fun getListMovie() : ArrayList<FilmEntity> = DataDummy.generateDummyMovies()
    private fun getListTvShow() : ArrayList<FilmEntity> = DataDummy.generateDummyTvShow()


    fun setMovie(movie: String) {
        this.titleMovie = movie
    }

    fun setTvShow(tvShow: String) {
        this.titletvShow = tvShow
    }

    fun getMovieDetail(): FilmEntity {
        lateinit var result: FilmEntity
        val listMovie = getListMovie()
        for (movie in listMovie) {
            if (movie.title == titleMovie) {
                result = movie
                break
            }
        }
        return result
    }


    fun getTvShowDetail(): FilmEntity {
        lateinit var result: FilmEntity
        val listTvShow = getListTvShow()
        for (tvShow in listTvShow) {
            if (tvShow.title == titletvShow) {
                result = tvShow
                break
            }
        }
        return result
    }





}