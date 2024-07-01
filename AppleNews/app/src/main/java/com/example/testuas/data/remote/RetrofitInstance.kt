package com.example.testuas.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Object responsible for providing Retrofit instances.
 */
object RetrofitInstance {

    private const val BASE_URL = "https://newsapi.org/v2/"

    // Lazily initialized Retrofit instance with Gson converter
    val api: NewsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }
}
