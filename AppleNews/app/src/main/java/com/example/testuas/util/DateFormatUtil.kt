package com.example.testuas.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatUtil {

    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    private val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())

    // Function to format a date string
    fun formatDate(dateString: String): String {
        return try {
            val date = inputFormat.parse(dateString)
            date?.let { outputFormat.format(it) } ?: dateString
        } catch (e: Exception) {
            dateString
        }
    }
}
