package com.dicoding.appfilm.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.appfilm.R
import com.dicoding.appfilm.data.source.local.entity.TvShowEntity
import com.dicoding.appfilm.databinding.ItemsListFilmBinding
import com.dicoding.appfilm.ui.detail.DetailActivity

class FavTvShowAdapter: PagedListAdapter<TvShowEntity, FavTvShowAdapter.FavTvShowViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavTvShowAdapter.FavTvShowViewHolder {
        val bindding = ItemsListFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavTvShowViewHolder(bindding)
    }


    override fun onBindViewHolder(
        holder: FavTvShowAdapter.FavTvShowViewHolder,
        position: Int
    ) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }

    }


    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    inner class FavTvShowViewHolder(private val binding: ItemsListFilmBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShowEntity) {

            with(binding) {
                tvItemTitle.text = tvShow.title
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tvShow.tvId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(tvShow.poster_path)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_refresh_black))
                    .error(R.drawable.ic_broken_image_black)
                    .into(imgPoster)
            }

        }

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {

            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.tvId == newItem.tvId
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}