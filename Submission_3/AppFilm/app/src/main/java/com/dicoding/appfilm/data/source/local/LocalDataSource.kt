package com.dicoding.appfilm.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao){

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getMovies()

    fun getAllTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getTvShow()

    fun getMovieWithId(movieId: String): LiveData<MovieEntity> =
        mFilmDao.getMovieById(movieId)

    fun getTvShowWithId(tvShowId: String): LiveData<TvShowEntity> =
        mFilmDao.getTvShowById(tvShowId)

    fun insertMovie(movie: List<MovieEntity>) = mFilmDao.insertMovie(movie)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mFilmDao.insertTvShow(tvShow)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> =
        mFilmDao.getFavMovie()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> =
        mFilmDao.getFavTvShow()

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.fav = newState
        mFilmDao.updateMovie(movie)
    }

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.fav = newState
        mFilmDao.updateTvShow(tvShow)
    }


    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(filmDao)
    }





}