package com.dicoding.appfilm.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tvshowentities")
data class TvShowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvId")
    var tvId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster_path")
    var poster_path: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "fav")
    var fav: Boolean = false
    )