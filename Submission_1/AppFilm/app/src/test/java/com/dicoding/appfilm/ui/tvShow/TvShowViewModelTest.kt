package com.dicoding.appfilm.ui.tvShow

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getMovie() {
        val tvShowEntites = viewModel.getTvShow()
        assertNotNull(tvShowEntites)
        assertEquals(20, tvShowEntites.size)
    }


}