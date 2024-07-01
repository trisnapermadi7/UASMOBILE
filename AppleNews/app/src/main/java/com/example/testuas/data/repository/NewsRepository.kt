package com.example.testuas.data.repository

import com.example.testuas.data.model.News
import com.example.testuas.data.remote.RetrofitInstance

/**
 * Repository for handling news data operations.
 */
object NewsRepository {

    private const val QUERY_DEFAULT = "apple"
    private const val DATE_FROM = "2024-06-22"
    private const val DATE_TO = "2024-06-22"
    private const val SORT_BY = "popularity"
    private const val API_KEY = "02bec1920c74474f97478fb1efbc434c"

    /**
     * Fetches all news articles.
     *
     * @return List of News articles fetched.
     */
    suspend fun getAll(): List<News> {
        val response = RetrofitInstance.api.getNews(
            query = QUERY_DEFAULT,
            from = DATE_FROM,
            to = DATE_TO,
            sortBy = SORT_BY,
            apiKey = API_KEY
        )
        return response.articles
    }

    /**
     * Searches news articles based on the provided query.
     *
     * @param query The search query.
     * @return List of News articles matching the search query.
     */
    suspend fun searchNews(query: String): List<News> {
        val response = RetrofitInstance.api.getNews(
            query = query,
            from = DATE_FROM,
            to = DATE_TO,
            sortBy = SORT_BY,
            apiKey = API_KEY
        )
        return response.articles
    }
}
