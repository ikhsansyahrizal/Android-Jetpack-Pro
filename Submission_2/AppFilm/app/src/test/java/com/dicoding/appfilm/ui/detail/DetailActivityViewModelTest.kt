package com.dicoding.appfilm.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailActivityViewModelTest {

    private lateinit var viewModel : DetailActivityViewModel
    private val dummyMovie = DataDummy.generateMovies()[0]
    private val dummyTvSHow = DataDummy.generateTvShow()[0]
    private val movieId = dummyMovie.moviesId
    private val tvShowId = dummyTvSHow.tvId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieEntity>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = DetailActivityViewModel(filmRepository)
        viewModel.setMovie(movieId)
        viewModel.setTvShow(tvShowId)
    }

    @Test
    fun setMovie() {
        viewModel.setMovie(dummyMovie.moviesId)
        assertEquals(dummyMovie.moviesId, movieId)
    }


    @Test
    fun getMovieDetail() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(filmRepository.getDetailMovies(movieId)).thenReturn(movie)
        val _viewModel = viewModel.getMovieDetail().value as MovieEntity
        verify(filmRepository).getDetailMovies(movieId)
        assertNotNull(_viewModel)
        assertEquals(dummyMovie.moviesId, _viewModel.moviesId)
        assertEquals(dummyMovie.title, _viewModel.title)
        assertEquals(dummyMovie.poster_path, _viewModel.poster_path)
        assertEquals(dummyMovie.overview, _viewModel.overview)

        viewModel.getMovieDetail().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)

    }


    @Test
    fun setTvShow(){
        viewModel.setTvShow(tvShowId)
        assertEquals(dummyTvSHow.tvId, tvShowId)
    }


    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvSHow

        `when`(filmRepository.getDetailTvShows(tvShowId)).thenReturn(tvShow)
        val _viewModel = viewModel.getTvShowDetail().value as TvShowEntity
        verify(filmRepository).getDetailTvShows(tvShowId)
        assertNotNull(_viewModel)
        assertEquals(dummyTvSHow.tvId, _viewModel.tvId)
        assertEquals(dummyTvSHow.title, _viewModel.title)
        assertEquals(dummyTvSHow.poster_path, _viewModel.poster_path)
        assertEquals(dummyTvSHow.overview, _viewModel.overview)

        viewModel.getTvShowDetail().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvSHow)
    }
}