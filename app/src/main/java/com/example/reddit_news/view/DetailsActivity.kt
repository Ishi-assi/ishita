package com.example.reddit_news.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.reddit_news.R
import com.example.reddit_news.common.Constants
import com.example.reddit_news.common.Utils
import com.example.reddit_news.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.detail_view.*


class DetailsActivity : AppCompatActivity(), DetailViewModel.DetailView {

    private var detailView: DetailViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view)
        supportActionBar!!.setTitle(resources.getString(R.string.detail))
        this.detailView = DetailViewModel(this)
    }

    override fun setArgs() {
        text_author.setText(resources.getString(R.string.author, intent.getStringExtra(Constants().author)?.toString()))
        text_detail.setText(resources.getString(R.string.title, intent.getStringExtra(Constants().title)?.toString()))
        text_date.setText(resources.getString(R.string.date, Utils.setDate(intent.getLongExtra(Constants().date, 0))))
        if (!intent.getStringExtra(Constants().image).isNullOrEmpty()) {
            Glide.with(this)
                .load(intent.getStringExtra(Constants().image)?.toString())
                .apply(
                    RequestOptions().override(
                        Utils.converttoDp(intent.getIntExtra(Constants().width, 0), this),
                        Utils.converttoDp(intent.getIntExtra(Constants().height, 0), this)
                    ).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                )
                .into(image_detail)
        }

    }
}