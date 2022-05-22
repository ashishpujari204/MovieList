package com.ashish.movielist

import android.app.Application
import com.ashish.movielist.di.retrofitModule
import com.ashish.movielist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MovieApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            androidLogger(Level.DEBUG)
            modules(
                listOf(
                    retrofitModule,
                    viewModelModule
                )
            )
        }
    }
}