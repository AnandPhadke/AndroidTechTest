package com.example.androidtechtest.utils

import java.text.SimpleDateFormat

fun formatDate(timestamp: Int): String {
    val sdf = SimpleDateFormat("EEE, MMM d")
    val timestamp = timestamp.toLong()
    val date = timestamp.let { java.util.Date( it.times(1000)) }

    return sdf.format(date)
}

fun formatDecimals(item: Double?): String {
    return " %.0f".format(item)
}