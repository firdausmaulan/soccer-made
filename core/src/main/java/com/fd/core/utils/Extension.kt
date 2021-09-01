package com.fd.core.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(imgResource : Any?) {
    Glide.with(context.applicationContext)
        .load(imgResource)
        .circleCrop()
        .into(this)
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.hide(){
    this.visibility = View.GONE
}