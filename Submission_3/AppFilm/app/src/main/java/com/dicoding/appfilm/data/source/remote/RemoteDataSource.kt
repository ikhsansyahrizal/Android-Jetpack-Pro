package com.dicoding.appfilm.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun loadAllMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResources.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.succes(jsonHelper.loadMovie())
            EspressoIdlingResources.decrement()

        }, SERVICE_LATENCY_IN_MILLIS)

        return resultMovie
    }

    fun loadAllTvShow(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResources.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed( {
            resultTvShow.value = ApiResponse.succes(jsonHelper.loadTvShow())
            EspressoIdlingResources.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultTvShow
    }



}