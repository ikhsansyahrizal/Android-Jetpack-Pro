package com.dicoding.appfilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.utils.DataDummy
import com.dicoding.appfilm.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepositoryTest(remote)

    private val movieResponse = DataDummy.generateDummyMovies()
    private val movieId = movieResponse[0].movieId

    private val tvShowResponse = DataDummy.generateDummyTvShow()
    private val tvShowId = tvShowResponse[0].tvId

    @Test
    fun getAllMovie() {

        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).loadAllMovie(any())
        val movieEntities = LiveDataTestUtils.getValue(filmRepository.getAllMovies())
        verify(remote).loadAllMovie(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.size.toLong())

    }


    @Test
    fun getAllTvShow() {

        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).loadAllTvShow(any())
        val tvShowEntities = LiveDataTestUtils.getValue(filmRepository.getAllTvShow())
        verify(remote).loadAllTvShow(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvShowEntities.size.toLong(), tvShowEntities.size.toLong())
    }


    @Test
    fun getMovieDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponse)
            null
        }.`when`(remote).loadAllMovie(any())
        val movieEntites = LiveDataTestUtils.getValue(filmRepository.getDetailMovies(movieId))
        verify(remote).loadAllMovie(any())
        assertNotNull(movieEntites)
        assertNotNull(movieEntites.title)
        assertNotNull(movieResponse[0].title, movieEntites.title)
    }


    @Test
    fun getTvShowDetail() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback)
                .onAllTvShowReceived(tvShowResponse)
            null
        }.`when`(remote).loadAllTvShow(any())
        val tvShowEntites = LiveDataTestUtils.getValue(filmRepository.getDetailTvShows(tvShowId))
        verify(remote).loadAllTvShow(any())
        assertNotNull(tvShowEntites)
        assertNotNull(tvShowEntites.title)
        assertNotNull(tvShowResponse[0].title, tvShowEntites.title)
    }

















}