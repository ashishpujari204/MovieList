package com.ashish.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val cards: List<Card>
): Parcelable