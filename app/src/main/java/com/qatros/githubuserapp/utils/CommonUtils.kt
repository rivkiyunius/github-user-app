package com.qatros.githubuserapp.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

/**
 * @author rivki
 * Created 28/03/22 at 21.53
 */

fun ImageView.showImages(url: String){
    Glide.with(this).load(url).into(this)
}

fun String.showToast(context: Context, lengthShow: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context, this, lengthShow).show()
}

