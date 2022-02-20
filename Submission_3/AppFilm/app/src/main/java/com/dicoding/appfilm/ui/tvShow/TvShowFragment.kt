package com.dicoding.appfilm.ui.tvShow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.appfilm.R
import com.dicoding.appfilm.databinding.FragmentTvShowBinding
import com.dicoding.appfilm.viewmodel.ViewModelFactory
import com.dicoding.appfilm.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvSHowAdapter = TvShowAdapter()
            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when(tvShows.status) {
                        Status.LOADING -> showLoading(true)
                        Status.SUCCES -> {
                            showLoading(false)
                            tvSHowAdapter.submitList(tvShows.data)
                            tvSHowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            showLoading(false)
                            Toast.makeText(context, resources.getString(R.string.error), Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                adapter = tvSHowAdapter
            }
        }

    }

    private fun showLoading(state: Boolean) {
        if (state) {
            fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
        } else {
            fragmentTvShowBinding.progressBar.visibility = View.INVISIBLE
        }
    }
}