package com.dicoding.appfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.appfilm.R
import com.dicoding.appfilm.data.FilmEntity
import com.dicoding.appfilm.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding : ActivityDetailBinding
    private lateinit var result: FilmEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        val actionbar = supportActionBar
        actionbar?.title = getString(R.string.activity_detail_title)
        actionbar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailActivityViewModel::class.java]


        val film = intent.getParcelableExtra<FilmEntity>(EXTRA_FILM) as FilmEntity
        val typeFilm = intent.getStringExtra(EXTRA_TYPE)

        result = if (typeFilm.equals("movie")) {
            viewModel.setMovie(film.title)
            viewModel.getMovieDetail()
        } else {
            viewModel.setTvShow(film.title)
            viewModel.getTvShowDetail()
        }
        showData(result)

        detailBinding.floatingBtnShare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            val link = "https://www.themoviedb.org/movie"
            share.putExtra(Intent.EXTRA_SUBJECT, "More Info ")
            share.putExtra(Intent.EXTRA_TEXT, link)
            startActivity(Intent.createChooser(share, "Share to"))
        }

    }

    private fun showData(filmEntity: FilmEntity) {
        with(detailBinding) {
            tvTitle.text = filmEntity.title
            tvReleaseDate.text = filmEntity.releaseDate
            tvGenre.text = filmEntity.genre
            tvDuration.text = filmEntity.duration
            tvDirector.text = filmEntity.Director
            tvOverview.text = filmEntity.overview

            Glide.with(root.context)
                .load(filmEntity.images)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
                .into(detailBinding.imgPoster)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_TYPE = "extra-type"
    }

}