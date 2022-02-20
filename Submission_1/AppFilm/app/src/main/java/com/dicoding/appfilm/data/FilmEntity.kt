package com.dicoding.appfilm.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmEntity(

    val images: Int,
    val title: String,
    val releaseDate: String,
    val genre: String,
    val duration: String,
    val overview: String,
    val Director: String,

) : Parcelable
