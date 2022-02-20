package com.dicoding.appfilm.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(

    var movieId: String,
    var title: String,
    var poster_path: String,
    var overview: String,
    var fav: Boolean

    ) : Parcelable