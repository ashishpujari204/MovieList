package com.ashish.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    val actions: List<Action>,
    val description: String,
    val movie_logo: String,
    val rating: Double,
    val title: String
): Parcelable