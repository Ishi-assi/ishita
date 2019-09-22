package com.example.reddit_news.viewmodel

import android.os.Handler
import com.example.reddit_news.common.ApiService
import com.example.reddit_news.common.RetrofitClient
import com.example.reddit_news.model.RedditChildrenResponse
import com.example.reddit_news.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private var mainView: MainView) {

    init {
        Handler().postDelayed({ getCurrentData() }, 100);
    }

    fun getCurrentData() {
        val call = RetrofitClient().getClient().create(ApiService::class.java).getData()
        call.enqueue(object : Callback<RedditNewsResponse> {
            override fun onResponse(call: Call<RedditNewsResponse>, response: Response<RedditNewsResponse>) {
                if (response.code() == 200) {
                    mainView.hideProgressBar()
                    val weatherResponse = response.body()!!
                    mainView.setDataToAdapter(weatherResponse.data?.children)
                }
            }

            override fun onFailure(call: Call<RedditNewsResponse>, t: Throwable) {
                mainView.hideProgressBar()
            }
        })
    }

    interface MainView {
        fun hideProgressBar()
        fun setDataToAdapter(arrList: List<RedditChildrenResponse>?)
    }
}