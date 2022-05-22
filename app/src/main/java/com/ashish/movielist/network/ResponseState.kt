package com.ashish.movielist.network

sealed class ResponseState<out T> {
    data class Error(val message: String) : ResponseState<Nothing>()
    data class Success<T>(val response: T) : ResponseState<T>()
    data class Loading<T>(val isLoading: Boolean) : ResponseState<T>()
}
