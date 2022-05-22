package com.ashish.movielist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val card_id: String,
    val card_template: String,
    val content: Content,
    val distance_threshold_in_meters: Int,
    val end_time: Int,
    val hide_on_use: Boolean,
    val hide_on_use_for_seconds: Int,
    val poi_lat_long: String,
    val priority: Double,
    val start_time: Int
): Parcelable