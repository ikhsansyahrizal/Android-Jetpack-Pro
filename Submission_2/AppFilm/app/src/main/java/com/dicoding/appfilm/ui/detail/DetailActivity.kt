package com.dicoding.appfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.appfilm.R
import com.dicoding.appfilm.data.source.local.entity.MovieEntity
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.databinding.ActivityDetailBinding
import com.dicoding.appfilm.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.activity_detail_title)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailActivityViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvShowId = extras.getString(EXTRA_TV)

            if (movieId != null) {
                showLoading(true)
                viewModel.setMovie(movieId)
                viewModel.getMovieDetail().observe(this, { movie ->
                    showLoading(false)
                    showDataMovie(movie)
                })
            }
            if (tvShowId != null) {
                showLoading(true)
                viewModel.setTvShow(tvShowId)
                viewModel.getTvShowDetail().observe(this, { tvShow ->
                    showLoading(false)
                    showDataTvShow(tvShow)
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
        with(detailBinding) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview

            Glide.with(root.context)
                .load(movie.poster_path)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailBinding.imgPoster)
        }


    }

    private fun showDataTvShow(tvShow: TvShowEntity) {
        with(detailBinding) {
            tvTitle.text = tvShow.title
            tvOverview.text = tvShow.overview

            Glide.with(root.context)
                .load(tvShow.poster_path)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailBinding.imgPoster)
        }


    }

    private fun showLoading(state: Boolean) {
        if (state) {
            detailBinding.progressBar.visibility = View.VISIBLE
        } else {
            detailBinding.progressBar.visibility = View.INVISIBLE
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