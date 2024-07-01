package com.example.testuas.data.model

// Model class for the response from the News API
data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<News>
)

// Model class representing a news article
data class News(
    val id: Int = 0,
    val source: Source? = null,
    val author: String?,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String
)

// Model class representing the source of a news article
data class Source(
    val id: String?,
    val name: String?
)
