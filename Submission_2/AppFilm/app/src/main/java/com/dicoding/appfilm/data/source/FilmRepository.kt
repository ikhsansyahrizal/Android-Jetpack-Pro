package com.dicoding.appfilm.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.data.source.remote.response.MovieResponse
import com.dicoding.appfilm.data.source.remote.response.TvShowResponse

class FilmRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    FIlmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(remoteData: RemoteDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData)
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val result = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.loadAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                val listMovie = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.poster_path,
                        response.overview)
                    listMovie.add(movie)
                }
                result.postValue(listMovie)
            }
        })

        return result
    }


    override fun getDetailMovies(movieId: String): LiveData<MovieEntity> {
        val result = MutableLiveData<MovieEntity>()

        remoteDataSource.loadAllMovie(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieResponse>) {
                 lateinit var movie: MovieEntity
                for (response in movieResponse) {
                    if (response.movieId == movieId) {

                        movie = MovieEntity(
                            response.movieId,
                            response.title,
                            response.poster_path,
                            response.overview)
                    }
                }
                result.postValue(movie)

            }
        })

        return result
    }


    override fun getAllTvShow(): LiveData<List<TvShowEntity>> {
        val result = MutableLiveData<List<TvShowEntity>>()

        remoteDataSource.loadAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                val listTvShow = ArrayList<TvShowEntity>()

                for (response in tvShowResponse) {
                    val tvShow = TvShowEntity(
                        response.tvId,
                        response.title,
                        response.poster_path,
                        response.overview)
                    listTvShow.add(tvShow)
                }
                result.postValue(listTvShow)
            }
        })

        return result
    }

    override fun getDetailTvShows(tvShowId: String): LiveData<TvShowEntity> {
        val result = MutableLiveData<TvShowEntity>()

        remoteDataSource.loadAllTvShow(object : RemoteDataSource.LoadTvShowCallback {
            override fun onAllTvShowReceived(tvShowResponse: List<TvShowResponse>) {
                lateinit var tvShow : TvShowEntity
                for (response in tvShowResponse) {
                    if (response.tvId == tvShowId) {
                        tvShow = TvShowEntity(
                            response.tvId,
                            response.title,
                            response.poster_path,
                            response.overview)
                    }
                }
                result.postValue(tvShow)
            }
        })
        return result
    }

}