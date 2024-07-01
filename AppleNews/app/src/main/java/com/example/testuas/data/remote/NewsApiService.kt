package com.example.testuas.data.remote

import com.example.testuas.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface representing News API service endpoints.
 */
interface NewsApiService {

    // Endpoint to fetch news articles based on query parameters
    @GET("everything")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}
