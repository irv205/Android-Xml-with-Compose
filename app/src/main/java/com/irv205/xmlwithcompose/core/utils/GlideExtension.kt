package com.irv205.xmlwithcompose.core.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.irv205.xmlwithcompose.R

fun <T> ImageView.setGlideImage(image: T?){
    try {
        Glide.with(context)
            .load(image)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(R.drawable.ic_back)
            .apply(RequestOptions.centerCropTransform())
            .into(this)
    } catch (e: Exception){}
}