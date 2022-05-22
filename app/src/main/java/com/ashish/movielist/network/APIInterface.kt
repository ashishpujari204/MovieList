package com.ashish.movielist.network

import com.ashish.movielist.model.Cards
import retrofit2.http.GET
import retrofit2.http.Url

interface APIInterface {

    @GET
    suspend fun getMovieList(@Url url: String): Cards
}