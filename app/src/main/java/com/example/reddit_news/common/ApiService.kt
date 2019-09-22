package com.example.reddit_news.common

import com.example.reddit_news.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("r/Kotlin/.json")
    fun getData(): Call<RedditNewsResponse>

}

