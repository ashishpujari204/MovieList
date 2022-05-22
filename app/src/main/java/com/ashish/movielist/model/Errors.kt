package com.ashish.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Errors(
    val message: String,
    val title: String
): Parcelable