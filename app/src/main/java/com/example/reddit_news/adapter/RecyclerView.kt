package com.example.reddit_news.adapter

import android.content.Context
import android.content.Intent
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.content_main.view.*
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.reddit_news.R
import com.example.reddit_news.common.Constants
import com.example.reddit_news.common.Utils
import com.example.reddit_news.model.RedditChildrenResponse
import com.example.reddit_news.view.DetailsActivity


class ViewAdapter(private val arrList: List<RedditChildrenResponse>?) : RecyclerView.Adapter<ViewAdapter.CustomViewHolder>() {

    private var context: Context?=null
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        context = p0.context
        return CustomViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.content_main, p0, false))
    }

    override fun getItemCount(): Int {
        if (arrList != null) {
            return arrList.size
        }else
        {
            return 0;
        }
    }

    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        if (arrList != null) {
            p0.bindItems(arrList.get(p1))
        }
    }

    class CustomViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        fun bindItems(data : RedditChildrenResponse){

            if(!data.data?.secure_media?.oembed?.thumbnail_url.isNullOrEmpty()) {
                itemView.content_text.setText(data.data?.title)
                itemView.content_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,14F)
                itemView.content_text.maxLines = 2
                Glide.with(itemView.context)
                        .load(data.data?.secure_media?.oembed?.thumbnail_url)
                        .apply(RequestOptions().override(Utils.converttoDp(data.data?.secure_media?.oembed?.width, itemView.context), Utils.converttoDp(data.data?.secure_media?.oembed?.height, itemView.context)).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC))
                        .into(itemView.image_title)
                itemView.image_title.visibility=View.VISIBLE

            } else {
                itemView.content_text.setText(data.data?.title)
                itemView.content_text.setTextSize(TypedValue.COMPLEX_UNIT_SP,24F)
                itemView.content_text.maxLines = 3
                itemView.image_title.visibility=View.GONE
                itemView.content_text.gravity = Gravity.CENTER
           }
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, DetailsActivity::class.java)
                intent.putExtra(Constants().image, data.data?.secure_media?.oembed?.thumbnail_url)
                intent.putExtra(Constants().width, data.data?.secure_media?.oembed?.width)
                intent.putExtra(Constants().height, data.data?.secure_media?.oembed?.height)
                intent.putExtra(Constants().author, data.data?.author)
                intent.putExtra(Constants().title, data.data?.title)
                intent.putExtra(Constants().date, data.data?.created)
                itemView.context.startActivity(intent)
            }
        }
    }
}



