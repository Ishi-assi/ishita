package com.example.reddit_news.common

import android.content.Context
import android.util.TypedValue
import java.text.SimpleDateFormat
import java.util.*


object Utils {
    fun converttoDp(pixels: Int?, context: Context): Int {
        return Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, pixels?.toFloat()!!, context.getResources().getDisplayMetrics()))
    }

    fun convertSpToPixels(sp: Float, context: Context): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics)
    }

    fun setDate(long: Long) : String?{
        val date = Date(long*1000)
        val df2 = SimpleDateFormat("dd/MM/yy", Locale.ENGLISH)
        return df2.format(date)
    }
}