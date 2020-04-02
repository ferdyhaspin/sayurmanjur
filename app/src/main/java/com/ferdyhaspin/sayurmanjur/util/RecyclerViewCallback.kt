package com.ferdyhaspin.sayurmanjur.util

import android.view.View
import android.widget.ImageView
import com.ferdyhaspin.sayurmanjur.model.Vegetable

/**
 * Created by ferdyhaspin on 02/04/20.
 * Copyright (c) 2020 SayurMayur Apps All rights reserved.
 */

interface RecyclerViewCallback {

    interface OnCLick {
        fun onItemClickListener(vararg view: View, item: Vegetable)
    }

}