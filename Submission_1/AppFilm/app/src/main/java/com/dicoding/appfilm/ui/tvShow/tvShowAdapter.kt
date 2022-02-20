package com.dicoding.appfilm.ui.tvShow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.appfilm.R
import com.dicoding.appfilm.data.FilmEntity
import com.dicoding.appfilm.databinding.ItemsListFilmBinding
import com.dicoding.appfilm.ui.detail.DetailActivity

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>(){

    private val listTvShow = ArrayList<FilmEntity>()

    fun setTvShow(tvShow: List<FilmEntity>?) {
        if (tvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvShowAdapter.TvShowViewHolder {
        val itemsTvShowBinding = ItemsListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }


    override fun onBindViewHolder(holder: TvShowAdapter.TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShow.size


    inner class TvShowViewHolder(private val binding: ItemsListFilmBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: FilmEntity) {
            with(binding) {
                tvItemTitle.text = tvShow.title
                tvItemDirecttor.text = tvShow.Director
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "tvShow")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.images)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }

    }



}