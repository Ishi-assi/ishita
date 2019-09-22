package com.example.reddit_news

import com.example.reddit_news.common.ApiService
import com.example.reddit_news.model.RedditChildrenResponse
import com.example.reddit_news.model.RedditDataResponse
import com.example.reddit_news.model.RedditNewsDataResponse
import com.example.reddit_news.model.RedditNewsResponse
import org.junit.Rule
import org.junit.Test
import org.junit.internal.runners.statements.Fail
import org.junit.runner.RunWith


class NewsTest{

    @Test
    fun getDataResponse() {
    var dataResponse = RedditDataResponse()
     if(dataResponse.children.isNullOrEmpty())
         print("Fail")
    else
         print("Success")
}

    @Test
    fun getNewsResponse(){
        var newsResponse = RedditNewsResponse()
        if(newsResponse.data?.children.isNullOrEmpty())
            print("Fail")
        else
            print("Success")
    }

    @Test
    fun getNewsDataResponse(){
        var newsDataResponse = RedditNewsDataResponse()
        if(newsDataResponse.author.isNullOrEmpty() || newsDataResponse.thumbnail.isNullOrEmpty()
            || newsDataResponse.thumbnail_url.isNullOrEmpty() || newsDataResponse.title.isNullOrEmpty() || newsDataResponse.url.isNullOrEmpty())
            print("Missing Value")
        else
            print("Success")
    }


}