package com.ashish.movielist.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.ashish.movielist.databinding.ActivityMainBinding
import com.ashish.movielist.model.Card
import com.ashish.movielist.network.ResponseState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieList : AppCompatActivity() {

    private val movieListViewModel by viewModel<MovieListViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        movieListViewModel.movieList.observe(this@MovieList) { cards ->
            when (cards) {
                is ResponseState.Success -> {
                    cards.response.let {
                        if (it.success) {
                            showMovieList(cards.response.data.cards)
                            binding.progressBar.isVisible =false
                        }
                    }
                }
                is ResponseState.Error -> {
                    Log.e("app", "Error")
                }
                is ResponseState.Loading -> {
                    binding.progressBar.isVisible = cards.isLoading
                }
            }
        }
    }

    private fun showMovieList(cards: List<Card>) {
        with(binding) {
            val dashboardAdapter = MovieListAdapter(cards)
            movieRecyclerView.apply {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = dashboardAdapter
            }
        }
    }
}