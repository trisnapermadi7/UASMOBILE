package com.example.testuas.presentation.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testuas.data.model.News
import com.example.testuas.presentation.screen.DetailContent
import com.example.testuas.ui.theme.TestUasTheme
import com.google.gson.Gson

/**
 * Activity to display detailed news content.
 */
class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val news = extractNewsFromIntent()

        setContent {
            TestUasTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    news?.let {
                        DetailContent(news = it)
                    } ?: run {
                        Text(text = "News not found", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }

    /**
     * Extracts News object from the intent extras using Gson.
     *
     * @return News object extracted from intent extras, or null if extraction fails.
     */
    private fun extractNewsFromIntent(): News? {
        val newsJson = intent.getStringExtra("extra_news")
        return Gson().fromJson(newsJson, News::class.java)
    }
}
