package com.ashish.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cards(
    val `data`: Data,
    val errors: Errors,
    val success: Boolean
): Parcelable