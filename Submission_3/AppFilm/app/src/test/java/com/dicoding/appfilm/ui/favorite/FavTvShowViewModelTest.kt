package com.dicoding.appfilm.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.appfilm.data.source.FilmRepository
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavTvShowViewModelTest {

    private val dummyTvShowTest = DataDummy.generateTvShow()[0]


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: FavTvShowViewModel

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavTvShowViewModel(filmRepository)

    }

    @Test
    fun getFavoriteTvShow() {

        val dummyTvShow= tvShowPagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(4)
        val tvShow = MutableLiveData<PagedList<TvShowEntity>>()
        tvShow.value = dummyTvShow

        Mockito.`when`(filmRepository.getTvShowFavorite()).thenReturn(tvShow)
        val tvShowEntity = viewModel.getFavoriteTvShow().value
        verify(filmRepository).getTvShowFavorite()
        assertNotNull(tvShowEntity)
        assertEquals(4, tvShowEntity?.size)

        viewModel.getFavoriteTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }

    @Test
    fun setFavoriteTvShow() {
        val _viewModel = viewModel.setFavoriteTvShow(dummyTvShowTest)
        assertNotNull(_viewModel)
    }
}


