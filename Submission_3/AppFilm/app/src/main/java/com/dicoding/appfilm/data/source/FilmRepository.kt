package com.dicoding.appfilm.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.appfilm.data.NetworkBoundResource
import com.dicoding.appfilm.data.source.local.LocalDataSource
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.data.source.remote.ApiResponse
import com.dicoding.appfilm.data.source.remote.RemoteDataSource
import com.dicoding.appfilm.data.source.remote.response.MovieResponse
import com.dicoding.appfilm.data.source.remote.response.TvShowResponse
import com.dicoding.appfilm.utils.AppExecutors
import com.dicoding.appfilm.vo.Resource

class FilmRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) :

    FIlmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors,
        ): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {

        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.loadAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val listMovie = ArrayList<MovieEntity>()

                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.poster_path,
                        response.overview,
                        false
                    )
                    listMovie.add(movie)
                }
                localDataSource.insertMovie(listMovie)
            }

        }.asLiveData()


    }


    override fun getDetailMovies(movieId: String): LiveData<Resource<MovieEntity>> {

        return object : NetworkBoundResource<MovieEntity, List<MovieResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieWithId(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.loadAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val listMovie = ArrayList<MovieEntity>()

                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.poster_path,
                        response.overview,
                        false
                    )
                    listMovie.add(movie)
                }
                localDataSource.insertMovie(listMovie)
            }


        }.asLiveData()


    }


    override fun getAllTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {

        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.loadAllTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val listTvShow = ArrayList<TvShowEntity>()

                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvId,
                        response.title,
                        response.poster_path,
                        response.overview,
                        false
                    )
                    listTvShow.add(tvShow)
                }
                localDataSource.insertTvShow(listTvShow)
            }

        }.asLiveData()

    }

    override fun getDetailTvShows(tvShowId: String): LiveData<Resource<TvShowEntity>> {

        return object : NetworkBoundResource<TvShowEntity, List<TvShowResponse>>(appExecutors) {

            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowWithId(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.loadAllTvShow()

            override fun saveCallResult(data: List<TvShowResponse>) {

                val listTvShow = ArrayList<TvShowEntity>()

                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.tvId,
                        response.title,
                        response.poster_path,
                        response.overview,
                        false
                    )
                    listTvShow.add(tvShow)
                }
                localDataSource.insertTvShow(listTvShow)
            }

        }.asLiveData()

    }

    override fun getMovieFavorite(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }


    override fun getTvShowFavorite(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }


    override fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }


}