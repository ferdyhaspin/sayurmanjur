package com.ferdyhaspin.sayurmanjur.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.ferdyhaspin.sayurmanjur.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by ferdyhaspin on 02/04/20.
 * Copyright (c) 2020 SayurMayur Apps All rights reserved.
 */

fun Context.parseJson(): String {
    return this.resources
        .openRawResource(R.raw.data)
        .bufferedReader()
        .use {
            it.readText()
        }
}

fun main(work: suspend (() -> Unit)) =
    CoroutineScope(Dispatchers.Main).launch {
        work()
    }

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}

fun ImageView.loadImage(url: String) =
    Glide.with(this)
        .setDefaultRequestOptions(
            RequestOptions()
                .placeholder(
                    R.drawable.ic_place_holder
                )
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        )
        .load(url)
        .into(this)

