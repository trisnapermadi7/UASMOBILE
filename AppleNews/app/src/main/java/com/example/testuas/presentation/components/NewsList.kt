package com.example.testuas.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testuas.data.model.News

/**
 * Composable function to display a list of news items using LazyColumn.
 *
 * @param news The list of News objects to display.
 * @param onNewsClick Callback function invoked when a news item is clicked.
 */
@Composable
fun NewsList(news: List<News>, onNewsClick: (News) -> Unit) {
    LazyColumn(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
        items(news) { newsItem ->
            NewsItem(news = newsItem, onNewsClick = onNewsClick)
        }
    }
}
