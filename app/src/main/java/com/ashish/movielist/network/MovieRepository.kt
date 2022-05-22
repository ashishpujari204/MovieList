package com.ashish.movielist.network

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ashish.movielist.Constants
import com.ashish.movielist.model.Cards
import com.ashish.movielist.utils.NetworkUtils

class MovieRepository(
    private val apiInterface: APIInterface,
    private val application: Application
) {

    private var movieListLiveData = MutableLiveData<ResponseState<Cards>>()
    val movieList: LiveData<ResponseState<Cards>>
        get() = movieListLiveData

    suspend fun getMovieList(url: String = Constants.MOVIE_LIST_URL): LiveData<ResponseState<Cards>> {
        if (NetworkUtils.isInternetAvailable(application)) {
            movieListLiveData.postValue(ResponseState.Loading(true))
            try {
                movieListLiveData.postValue(ResponseState.Success(
                    apiInterface.getMovieList(
                        url
                    )
                ))
            } catch (e: Exception) {
                movieListLiveData.postValue(ResponseState.Loading(false))
                movieListLiveData.postValue(ResponseState.Error(e.toString()))
            }
        } else {
            movieListLiveData.postValue(ResponseState.Error("No internet available"))
        }
        return movieListLiveData
    }
}