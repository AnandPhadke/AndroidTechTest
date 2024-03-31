package com.example.androidtechtest.core.utils

import java.io.InputStreamReader
import java.text.SimpleDateFormat

object Utils {
    fun formatDate(timestamp: Int): String {
        val sdf = SimpleDateFormat("EEE, MMM d")
        val timestamp = timestamp.toLong()
        val date = timestamp.let { java.util.Date(it.times(1000)) }

        return sdf.format(date)
    }

    fun formatDecimals(item: Double?): String {
        return " %.0f".format(item)
    }

    fun readFileFromResource(fileName: String): String {
        val inputStream = Utils::class.java.getResourceAsStream(fileName)
        val builder = StringBuilder()
        val reader = InputStreamReader(inputStream,"UTF-8")
        reader.readLines().forEach{
            builder.append(it)
        }
        return builder.toString()
    }
}