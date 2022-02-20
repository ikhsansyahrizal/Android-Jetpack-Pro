package com.dicoding.appfilm.di

import android.content.Context
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): FilmRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return FilmRepository.getInstance(remoteDataSource)
    }
}