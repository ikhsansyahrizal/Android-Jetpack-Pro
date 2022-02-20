package com.dicoding.appfilm.utils

import com.dicoding.appfilm.data.source.local.entity.MovieEntity

object DataDummyTesting {


    fun generateDummyTesting(): ArrayList<MovieEntity> {

        val dummyData = ArrayList<MovieEntity>()

        dummyData.add(MovieEntity(
            "m1",
            "Shang-Chi and the Legend of the Ten Rings",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
            "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization."
        ))

        dummyData.add(MovieEntity(
            "tv1",
            "Squid Game",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
            "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor."
        ))

        return dummyData
    }


}