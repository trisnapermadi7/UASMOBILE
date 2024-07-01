package com.example.testuas.viewmodel
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testuas.data.model.News
import com.example.testuas.data.repository.NewsRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // Mutable state variables to hold query, list of news, loading state, and error message
    val query = mutableStateOf("")
    val newsList = mutableStateOf<List<News>>(emptyList())
    val isLoading = mutableStateOf(false)
    val errorMessage = mutableStateOf<String?>(null)

    init {
        // Fetch news when ViewModel is created
        fetchNews()
    }

    // Function to fetch all news
    private fun fetchNews() {
        viewModelScope.launch {
            isLoading.value = true // Set loading state to true initially
            try {
                val news = NewsRepository.getAll()
                newsList.value = news
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }

    // Function to search news based on current query
    fun searchNews() {
        if (query.value.isBlank()) {
            // Handle case where query is empty
            newsList.value = emptyList()
            return
        }

        isLoading.value = true
        errorMessage.value = null
        viewModelScope.launch {
            try {
                val news = NewsRepository.searchNews(query.value)
                newsList.value = news
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }
}
