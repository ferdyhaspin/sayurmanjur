package com.ferdyhaspin.sayurmanjur.ui.main

import android.view.View
import com.ferdyhaspin.sayurmanjur.R
import com.ferdyhaspin.sayurmanjur.databinding.ItemProductBinding
import com.ferdyhaspin.sayurmanjur.model.Vegetable
import com.ferdyhaspin.sayurmanjur.util.RecyclerViewCallback
import com.ferdyhaspin.sayurmanjur.util.loadLocal
import com.xwray.groupie.databinding.BindableItem

/**
 * Created by ferdyhaspin on 02/04/20.
 * Copyright (c) 2020 SayurMayur Apps All rights reserved.
 */

class VegetableItem(
    private val vegetable: Vegetable,
    private val onClick: RecyclerViewCallback.OnCLick
) : BindableItem<ItemProductBinding>() {

    override fun getLayout() = R.layout.item_product

    override fun bind(viewBinding: ItemProductBinding, position: Int) {
        viewBinding.item = vegetable
        val image = viewBinding.rivPhoto
        val name = viewBinding.tvName as View
        val nameEn = viewBinding.tvNameEn as View
        image.loadLocal(vegetable.photo)
        viewBinding.root.setOnClickListener {
            onClick.onItemClickListener(image, name, nameEn, item = vegetable)
        }
    }
}