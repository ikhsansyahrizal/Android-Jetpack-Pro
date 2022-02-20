package com.dicoding.appfilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.appfilm.data.source.local.LocalDataSource
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.local.room.FilmDao
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.utils.AppExecutors
import com.dicoding.appfilm.utils.DataDummy
import com.dicoding.appfilm.utils.LiveDataTestUtils
import com.dicoding.appfilm.utils.PagedListUtils
import com.dicoding.appfilm.vo.Resource
import com.nhaarman.mockitokotlin2.doNothing
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val dao = mock(FilmDao::class.java)

    private val  fakeFilmRepositoryTest= FakeFilmRepositoryTest(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateDummyMovies()

    private val tvShowResponse = DataDummy.generateDummyTvShow()

    private val movieId = movieResponse[0].title
    private val tvShowId = tvShowResponse[0].title

    @Test
    fun getAllMovie() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        fakeFilmRepositoryTest.getAllMovies()

        val movieEntities = Resource.succes(PagedListUtils.mockPagedList(DataDummy.generateMovies()))
        verify(local).getAllMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(), movieEntities.data?.size?.toLong())

    }

    @Test
    fun getDetailMovie() {

        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateMovies()[0]
        `when`(local.getMovieWithId(movieId)).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtils.getValue(fakeFilmRepositoryTest.getDetailMovies(movieId))
        verify(local).getMovieWithId(movieId)
        assertNotNull(movieEntity.data)
        assertNotNull(movieEntity.data?.title)
        assertEquals(movieResponse[0].title, movieEntity.data?.title)

    }


    @Test
    fun getAllTvShow() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        fakeFilmRepositoryTest.getAllTvShow()

        val tvShowEntities = Resource.succes(PagedListUtils.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getAllTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow(){

        val dummyTvShow = MutableLiveData<TvShowEntity>()
        dummyTvShow.value = DataDummy.generateTvShow()[0]
        `when`(local.getTvShowWithId(tvShowId)).thenReturn(dummyTvShow)

        val tvShowEntity = LiveDataTestUtils.getValue(fakeFilmRepositoryTest.getDetailTvShows(tvShowId))
        verify(local).getTvShowWithId(tvShowId)
        assertNotNull(tvShowEntity.data)
        assertNotNull(tvShowEntity.data?.title)
        assertEquals(tvShowResponse[0].title, tvShowEntity.data?.title)

    }


    @Test
    fun getAllFavMovie() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        fakeFilmRepositoryTest.getMovieFavorite()

        val FavMovieEntities = Resource.succes(PagedListUtils.mockPagedList(DataDummy.generateMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(FavMovieEntities)
        assertEquals(movieResponse.size.toLong(), FavMovieEntities.data?.size?.toLong())

    }


    @Test
    fun getAllFavTvShow() {

        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        fakeFilmRepositoryTest.getTvShowFavorite()

        val FavTvSHowEntities = Resource.succes(PagedListUtils.mockPagedList(DataDummy.generateTvShow()))
        verify(local).getFavoriteTvShow()
        assertNotNull(FavTvSHowEntities)
        assertEquals(tvShowResponse.size.toLong(), FavTvSHowEntities.data?.size?.toLong())

    }



    @Test
    fun setMovieFav() {
        val localData = LocalDataSource.getInstance(dao)
        val datadummy = DataDummy.generateMovies()[0]
        val expectedDataDummy = datadummy.copy(fav = true)

        doNothing().`when`(dao).updateMovie(expectedDataDummy)
        localData.setMovieFavorite(datadummy, true)

        verify(dao, times(1)).updateMovie(expectedDataDummy)
    }


    @Test
    fun setTvShowFav() {
        val localData = LocalDataSource.getInstance(dao)
        val datadummy = DataDummy.generateTvShow()[0]
        val expectedDataDummy = datadummy.copy(fav = true)

        doNothing().`when`(dao).updateTvShow(expectedDataDummy)
        localData.setTvShowFavorite(datadummy, true)

        verify(dao, times(1)).updateTvShow(expectedDataDummy)

    }
















}