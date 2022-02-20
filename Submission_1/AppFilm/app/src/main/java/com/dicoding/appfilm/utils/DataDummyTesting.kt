package com.dicoding.appfilm.utils

object DataDummyTesting {

    data class DataTesting(
        val title: String,
        val release: String,
        val genre: String,
        val duration: String,
        val director: String,
        val overview: String,
    )

    fun generateDummyTesting(): ArrayList<DataTesting> {

        val dummyData = ArrayList<DataTesting>()

        dummyData.add(DataTesting(
            "A Star Is Born",
            "10/05/2018",
            "Drama, Romance, Music",
            "2h 16m",
            "Bradley Cooper",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
        ))

        dummyData.add(DataTesting(
            "Arrow",
            "2012",
            "Crime, Drama, Mystery, Action & Adventure",
            "42m",
            "Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."

        ))

        return dummyData
    }


}