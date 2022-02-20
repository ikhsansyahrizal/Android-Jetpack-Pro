package com.dicoding.appfilm.utils

import android.content.Context
import com.dicoding.appfilm.data.source.remote.response.MovieResponse
import com.dicoding.appfilm.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }


    fun loadMovie(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("Movies.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val id = movie.getString("id")
                val title = movie.getString("title")
                val poster_path = movie.getString("poster_path")
                val overview = movie.getString("overview")

                val movieResponse = MovieResponse(id, title, poster_path, overview, false)
                list.add(movieResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }



    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShow.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvShow = listArray.getJSONObject(i)

                val id = tvShow.getString("id")
                val title = tvShow.getString("title")
                val poster_path = tvShow.getString("poster_path")
                val overview = tvShow.getString("overview")

                val tvShowResponse = TvShowResponse(id, title, poster_path, overview, false)
                list.add(tvShowResponse)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }



}