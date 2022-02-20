package com.dicoding.appfilm.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(

    var tvId: String,
    var title: String,
    var poster_path: String,
    var overview: String,

    ) : Parcelable