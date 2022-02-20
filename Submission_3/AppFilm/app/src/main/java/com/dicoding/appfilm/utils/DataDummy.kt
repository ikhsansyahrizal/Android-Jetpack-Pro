package com.dicoding.appfilm.utils

import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.remote.response.MovieResponse
import com.dicoding.appfilm.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): List<MovieResponse> {

        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
            "1",
            "A Star Is Born",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/buz506hPSQVR26ZpcHjuA830iAS.jpg",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            false
        ))

        movies.add(MovieResponse(
            "2",
            "Alita : Battle Angle",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            false
        ))

        movies.add(MovieResponse(
            "3",
            "Aquaman",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            false
        ))

        movies.add(MovieResponse(
            "4",
            "Bohemian Rhapsody",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gbmkFWdtihe1VfydTDsieQ6VfGL.jpg",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            false
        ))

        movies.add(MovieResponse(
            "5",
            "Cold Pursuit",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            false
        ))


        movies.add(MovieResponse(
            "6",
            "Creed",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BfTsk5VWuw8FCocAhCyqnRbEzq.jpg",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            false
        ))


        movies.add(MovieResponse(
            "7",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IgyMP3YDAPt2PFqu50UcVqqRlG.jpg",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            false
        ))


        movies.add(MovieResponse(
            "8",
            "Glass",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9CpYHHtykjQZowRE2TZyYJMhZ9l.jpg",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            false
        ))


        movies.add(MovieResponse(
            "9",
            "How to Train Your Dragon: The Hidden World",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            false
        ))


        movies.add(MovieResponse(
            "10",
            "Avengers: Infinity War",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            false
        ))



        movies.add(MovieResponse(
            "11",
            "Mary Queen of Scots",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            false
        ))


        return movies
    }


    fun generateDummyTvShow(): ArrayList<TvShowResponse> {

        val tvShow = ArrayList<TvShowResponse>()

        tvShow.add(TvShowResponse(
            "1",
            "Arrow",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v6zknpjyE9NyBj6MCnlZJ1w58Se.jpg",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            false
        ))


        tvShow.add(TvShowResponse(
            "2",
            "Doom Patrol",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            false
        ))


        tvShow.add(TvShowResponse(
            "3",
            "Dragon Ball",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            false
        ))


        tvShow.add(TvShowResponse(
            "4",
            "Fairy Tail",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            false
        ))


        tvShow.add(TvShowResponse(
            "5",
            "Family Guy",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9RBeCo8QSaoJLmmuzlwzVH3Hi12.jpg",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            false
        ))


        tvShow.add(TvShowResponse(
            "6",
            "The Flash",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            false
        ))


        tvShow.add(TvShowResponse(
            "7",
            "Game of Thrones",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/44rw2cOQrgUthZMhp3eibpXVy9p.jpg",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors",
            false
        ))


        tvShow.add(TvShowResponse(
            "8",
            "Gotham",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            false
        ))


        tvShow.add(TvShowResponse(
            "9",
            "Grey's Anatomy",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            false
        ))


        tvShow.add(TvShowResponse(
            "10",
            "Hanna",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pe10EUjgO2jgwiu01MAv9l3IjxG.jpg",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            false
        ))


        tvShow.add(TvShowResponse(
            "11",
            "Marvel's Iron Fist",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/49XsMQpVsJEZfHiSipqXm9Wahf9.jpg",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            false
        ))

        return tvShow
    }


    fun generateMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(MovieEntity(
            "1",
            "A Star Is Born",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/buz506hPSQVR26ZpcHjuA830iAS.jpg",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            false
        ))

        movies.add(MovieEntity(
            "2",
            "Alita : Battle Angle",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            false
        ))

        movies.add(MovieEntity(
            "3",
            "Aquaman",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            false
        ))

        movies.add(MovieEntity(
            "4",
            "Bohemian Rhapsody",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gbmkFWdtihe1VfydTDsieQ6VfGL.jpg",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            false
        ))

        movies.add(MovieEntity(
            "5",
            "Cold Pursuit",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            false
        ))


        movies.add(MovieEntity(
            "6",
            "Creed",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BfTsk5VWuw8FCocAhCyqnRbEzq.jpg",
            "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
            false
        ))


        movies.add(MovieEntity(
            "7",
            "Fantastic Beasts: The Crimes of Grindelwald",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7IgyMP3YDAPt2PFqu50UcVqqRlG.jpg",
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            false
        ))


        movies.add(MovieEntity(
            "8",
            "Glass",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9CpYHHtykjQZowRE2TZyYJMhZ9l.jpg",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            false
        ))


        movies.add(MovieEntity(
            "9",
            "How to Train Your Dragon: The Hidden World",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            false
        ))


        movies.add(MovieEntity(
            "10",
            "Avengers: Infinity War",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            false
        ))



        movies.add(MovieEntity(
            "11",
            "Mary Queen of Scots",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            false
        ))


        return movies
    }


    fun generateTvShow(): ArrayList<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(
            "1",
            "Arrow",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/v6zknpjyE9NyBj6MCnlZJ1w58Se.jpg",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            false
        ))


        tvShow.add(TvShowEntity(
            "2",
            "Doom Patrol",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            false
        ))


        tvShow.add(TvShowEntity(
            "3",
            "Dragon Ball",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            false
        ))


        tvShow.add(TvShowEntity(
            "4",
            "Fairy Tail",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            false
        ))


        tvShow.add(TvShowEntity(
            "5",
            "Family Guy",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9RBeCo8QSaoJLmmuzlwzVH3Hi12.jpg",
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            false
        ))


        tvShow.add(TvShowEntity(
            "6",
            "The Flash",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            false
        ))


        tvShow.add(TvShowEntity(
            "7",
            "Game of Thrones",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/44rw2cOQrgUthZMhp3eibpXVy9p.jpg",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors",
            false
        ))


        tvShow.add(TvShowEntity(
            "8",
            "Gotham",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            false
        ))


        tvShow.add(TvShowEntity(
            "9",
            "Grey's Anatomy",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            false
        ))


        tvShow.add(TvShowEntity(
            "10",
            "Hanna",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pe10EUjgO2jgwiu01MAv9l3IjxG.jpg",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            false
        ))


        tvShow.add(TvShowEntity(
            "11",
            "Marvel's Iron Fist",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/49XsMQpVsJEZfHiSipqXm9Wahf9.jpg",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            false
        ))

        return tvShow
    }


}