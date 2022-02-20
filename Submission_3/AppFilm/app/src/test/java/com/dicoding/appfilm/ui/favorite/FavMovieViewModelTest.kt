package com.dicoding.appfilm.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavMovieViewModelTest {

    private val dummyMovieTest = DataDummy.generateMovies()[0]


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FavMovieViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavMovieViewModel(filmRepository)

    }


    @Test
    fun getFavoriteMovie() {

        val dummyMovie= moviePagedList
        `when`(dummyMovie.size).thenReturn(4)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMovie

        `when`(filmRepository.getMovieFavorite()).thenReturn(movie)
        val movieEntity = viewModel.getFavoriteMovie().value
        verify(filmRepository).getMovieFavorite()
        assertNotNull(movieEntity)
        assertEquals(4, movieEntity?.size)

        viewModel.getFavoriteMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun setFavoriteMovie() {
        val _viewModel = viewModel.setFavoriteMovie(dummyMovieTest)
        assertNotNull(_viewModel)
    }
}