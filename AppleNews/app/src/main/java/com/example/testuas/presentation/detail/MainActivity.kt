package com.example.testuas.presentation.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testuas.ui.theme.TestUasTheme
import com.example.testuas.presentation.components.NewsList
import com.example.testuas.presentation.components.TopBar
import com.example.testuas.presentation.components.SearchBar
import com.example.testuas.viewmodel.MainViewModel
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewModel using viewModels delegate from Jetpack Lifecycle library
        val viewModel: MainViewModel by viewModels()

        setContent {
            TestUasTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column {
                        // Display the top app bar
                        TopBar()

                        // Observe ViewModel state variables using by viewModel delegate
                        val query by viewModel.query
                        val newsList by viewModel.newsList
                        val isLoading by viewModel.isLoading
                        val errorMessage by viewModel.errorMessage

                        // Display search bar and search button
                        SearchBar(query) { viewModel.query.value = it }
                        Button(
                            onClick = { viewModel.searchNews() },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 1.dp)
                                .height(40.dp)
                        ) {
                            Text("Search", fontSize = 15.sp)
                        }

                        // Display loading indicator, error message, or news list based on ViewModel state
                        if (isLoading) {
                            CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                        } else if (errorMessage != null) {
                            Text(text = "Error: $errorMessage", modifier = Modifier.padding(16.dp))
                        } else {
                            // Display news list
                            NewsList(news = newsList) { news ->
                                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                                    putExtra("extra_news", Gson().toJson(news))
                                }
                                startActivity(intent)
                            }
                        }
                    }
                }
            }
        }
    }
}
