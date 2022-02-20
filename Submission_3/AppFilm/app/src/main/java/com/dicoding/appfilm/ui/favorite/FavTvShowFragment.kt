package com.dicoding.appfilm.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.appfilm.R
import com.dicoding.appfilm.databinding.FragmentFavTvShowBinding
import com.dicoding.appfilm.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class FavTvShowFragment : Fragment() {

    private lateinit var binding: FragmentFavTvShowBinding
    private lateinit var adapter: FavTvShowAdapter
    private lateinit var viewModel: FavTvShowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding.rvTvShows)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavTvShowViewModel::class.java]

            adapter = FavTvShowAdapter()
            showLoading(true)
            viewModel.getFavoriteTvShow().observe(viewLifecycleOwner, { tvShow ->
                showLoading(false)
                adapter.submitList(tvShow)
            })

            with(binding.rvTvShows) {
                layoutManager = LinearLayoutManager(context)
                adapter = this@FavTvShowFragment.adapter
            }


        }

    }


    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {

        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int {
            return makeMovementFlags(0, ItemTouchHelper.LEFT)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

            if (view != null) {
                val swipePosition = viewHolder.adapterPosition
                val model = adapter.getSwipedData(swipePosition)
                model?.let { viewModel.setFavoriteTvShow(it) }

                val snackbar = Snackbar.make(view as View, R.string.warning, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.ok) { _ ->
                    model?.let { viewModel.setFavoriteTvShow(it) }
                }
                snackbar.show()
            }

        }

    })

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.INVISIBLE
        }
    }

}