package com.example.testuas.presentation.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.testuas.data.model.News
import com.example.testuas.util.DateFormatUtil

@Composable
fun DetailContent(news: News) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            NewsImage(news.urlToImage ?: "")
            NewsTitle(news.title)
            NewsAuthorAndDate(author = news.author ?: "Unknown", date = news.publishedAt)
            NewsDescription(description = news.description ?: "No description available")
        }
    }
}

@Composable
fun NewsImage(imageUrl: String) {
    // Display an image with 16:9 aspect ratio, filling the width
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f),
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun NewsTitle(title: String) {
    // Display the news title with specified styling
    Text(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2
    )
}

@Composable
fun NewsAuthorAndDate(author: String, date: String) {
    // Display the news author and date in a row
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = author,
            fontSize = 12.sp,
        )

        Spacer(modifier = Modifier.width(4.dp))

        // Gray circle divider
        Canvas(
            modifier = Modifier.size(4.dp)
        ) {
            drawCircle(Color.Gray)
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Date text
        Text(
            text = DateFormatUtil.formatDate(date),
            fontSize = 12.sp,
        )
    }
}

@Composable
fun NewsDescription(description: String) {
    // Display the news description with padding
    Text(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        text = description,
        fontSize = 14.sp,
    )
}
