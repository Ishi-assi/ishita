package com.example.reddit_news.common
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    fun getClient():Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants().BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}