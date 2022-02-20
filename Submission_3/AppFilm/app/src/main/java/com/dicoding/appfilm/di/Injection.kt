package com.dicoding.appfilm.di

import android.content.Context
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.LocalDataSource
import com.dicoding.appfilm.data.source.local.room.FilmDatabase
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.utils.AppExecutors
import com.dicoding.appfilm.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}