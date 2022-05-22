package com.ashish.movielist.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.movielist.model.Cards
import com.ashish.movielist.network.MovieRepository
import com.ashish.movielist.network.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO) {
            movieRepository.getMovieList()
        }
    }

    val movieList : LiveData<ResponseState<Cards>>
    get() = movieRepository.movieList
}