package com.dicoding.appfilm.data.source.remote

import android.os.Handler
import android.os.Looper
import com.dicoding.appfilm.data.source.remote.response.MovieResponse
import com.dicoding.appfilm.data.source.remote.response.TvShowResponse
import com.dicoding.appfilm.utils.EspressoIdlingResources
import com.dicoding.appfilm.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper){

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 1000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper)
            }
    }

    fun loadAllMovie(callback : LoadMoviesCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed({
            callback.onAllMoviesReceived(jsonHelper.loadMovie())
            EspressoIdlingResources.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun loadAllTvShow(callback: LoadTvShowCallback) {
        EspressoIdlingResources.increment()
        handler.postDelayed( {
            callback.onAllTvShowReceived(jsonHelper.loadTvShow())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse : List<MovieResponse>)
    }

    interface LoadTvShowCallback {
        fun onAllTvShowReceived(tvShowResponse : List<TvShowResponse>)
    }


}