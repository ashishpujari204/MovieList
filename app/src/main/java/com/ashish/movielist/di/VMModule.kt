package com.ashish.movielist.di

import com.ashish.movielist.ui.movie.MovieListViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { MovieListViewModel(get()) }
}