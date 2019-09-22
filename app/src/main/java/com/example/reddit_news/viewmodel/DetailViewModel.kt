package com.example.reddit_news.viewmodel

class DetailViewModel(private var detailView:DetailView){

    init {
        detailView.setArgs()
    }

    public interface DetailView{
        fun setArgs()
    }
}