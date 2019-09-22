package com.example.reddit_news.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reddit_news.R
import com.example.reddit_news.adapter.ViewAdapter
import com.example.reddit_news.model.RedditChildrenResponse
import com.example.reddit_news.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),MainViewModel.MainView {

    private var mainViewModel:MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setTitle(resources.getString(R.string.reddit_news))
        this.mainViewModel = MainViewModel(this)
    }

    override fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun setDataToAdapter(arrList: List<RedditChildrenResponse>?)
    {
        recyclerview.visibility = View.VISIBLE
        val linearLayoutManager = LinearLayoutManager(this)
        val adapter = ViewAdapter(arrList)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = adapter
    }
}


