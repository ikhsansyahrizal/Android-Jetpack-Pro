package com.dicoding.appfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.appfilm.R
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.databinding.ActivityDetailBinding
import com.dicoding.appfilm.viewmodel.ViewModelFactory
import com.dicoding.appfilm.vo.Status

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding
    private lateinit var viewModel: DetailActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.activity_detail_title)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailActivityViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TV)

            if (movieId != null) {
                viewModel.setMovie(movieId)
                viewModel.movie.observe(this, { movies ->
                    when (movies.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCES -> if (movies.data != null) {
                            showLoading(false)
                            showDataMovie(movies.data)
                        }
                        Status.ERROR -> {
                            showLoading(true)
                            Toast.makeText(applicationContext, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
                        }
                    }
                })

            }
            if (tvShowId != null) {
                viewModel.setTvShow(tvShowId)
                viewModel.tvShow.observe(this, { tvShows ->
                    when (tvShows.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCES -> if (tvShows.data != null) {
                            showLoading(false)
                            showDataTvShow(tvShows.data)
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(applicationContext, getString(R.string.error), Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }




        detailBinding.floatingBtnShare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            val link = "https://www.themoviedb.org/movie"
            share.putExtra(Intent.EXTRA_SUBJECT, "More Info ")
            share.putExtra(Intent.EXTRA_TEXT, link)
            startActivity(Intent.createChooser(share, "Share to"))
        }

    }

    private fun showDataMovie(movie: MovieEntity) {

        var status = movie.fav
        setFavorite(status)

        with(detailBinding) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview

            Glide.with(root.context)
                .load(movie.poster_path)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailBinding.imgPoster)

            fabFavorite.setOnClickListener {
                status = !status
                setFavorite(status)
                viewModel.setFavorite()
            }

        }


    }

    private fun showDataTvShow(tvShow: TvShowEntity) {

        var status = tvShow.fav
        setFavorite(status)

        with(detailBinding) {
            tvTitle.text = tvShow.title
            tvOverview.text = tvShow.overview

            Glide.with(root.context)
                .load(tvShow.poster_path)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailBinding.imgPoster)

            fabFavorite.setOnClickListener{
                status = !status
                setFavorite(status)
                viewModel.setFavorite()
            }
        }


    }

    private fun showLoading(state: Boolean) {
        if (state) {
            detailBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailBinding.progressBar.visibility = View.INVISIBLE
        }
    }

    private fun setFavorite(state: Boolean) {
        if (state) {
            detailBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            detailBinding.fabFavorite.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite_border
                )
            )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    companion object {
        const val EXTRA_MOVIE = "extra_film"
        const val EXTRA_TV = "extra-type"
    }

}