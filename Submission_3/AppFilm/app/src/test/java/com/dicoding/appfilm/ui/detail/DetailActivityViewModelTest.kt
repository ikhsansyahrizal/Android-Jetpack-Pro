package com.dicoding.appfilm.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.appfilm.data.source.FakeFilmRepositoryTest
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.LocalDataSource
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.utils.AppExecutors
import com.dicoding.appfilm.utils.DataDummy
import com.dicoding.appfilm.utils.LiveDataTestUtils
import com.dicoding.appfilm.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

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
        val dummyMovieDetail = Resource.succes(DataDummy.generateMovies()[0])
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = dummyMovieDetail

        `when`(filmRepository.getDetailMovies(movieId)).thenReturn(movie)

        viewModel.movie.observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovieDetail)

        assertNotNull(dummyMovieDetail)
        assertEquals(dummyMovieDetail.data?.moviesId, dummyMovie.moviesId)
    }


    @Test
    fun setTvShow(){
        viewModel.setTvShow(tvShowId)
        assertEquals(dummyTvSHow.tvId, tvShowId)
    }


    @Test
    fun getTvShowDetail() {
        val dummyTvShowDetail = Resource.succes(DataDummy.generateTvShow()[0])
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = dummyTvShowDetail

        `when`(filmRepository.getDetailTvShows(tvShowId)).thenReturn(tvShow)

        viewModel.tvShow.observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShowDetail)

        assertNotNull(dummyTvShowDetail)
        assertEquals(dummyTvShowDetail.data?.tvId, dummyTvSHow.tvId)
    }
}