package com.dicoding.appfilm.ui.detail

import com.dicoding.appfilm.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailActivityViewModelTest {

    private lateinit var viewModel : DetailActivityViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvSHow = DataDummy.generateDummyTvShow()[0]
    private val movieTitle = dummyMovie.title
    private val tvShowTitle = dummyTvSHow.title


    @Before
    fun setUp() {
        viewModel = DetailActivityViewModel()
    }


    @Test
    fun setMovie() {
        viewModel.setMovie(dummyMovie.title)
        assertEquals(dummyMovie.title, movieTitle)
    }


    @Test
    fun getMovieDetail() {
        viewModel.setMovie(dummyMovie.title)
        val movieEntity = viewModel.getMovieDetail()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.images, movieEntity.images)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.Director, movieEntity.Director)

    }


    @Test
    fun setTvShow(){
        viewModel.setTvShow(tvShowTitle)
        assertEquals(dummyTvSHow.title, tvShowTitle)
    }


    @Test
    fun getTvShowDetail() {
        viewModel.setTvShow(dummyTvSHow.title)
        val tvShowEntity = viewModel.getTvShowDetail()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvSHow.images, tvShowEntity.images)
        assertEquals(dummyTvSHow.title, tvShowEntity.title)
        assertEquals(dummyTvSHow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvSHow.genre, tvShowEntity.genre)
        assertEquals(dummyTvSHow.duration, tvShowEntity.duration)
        assertEquals(dummyTvSHow.overview, tvShowEntity.overview)
        assertEquals(dummyTvSHow.Director, tvShowEntity.Director)
    }
}