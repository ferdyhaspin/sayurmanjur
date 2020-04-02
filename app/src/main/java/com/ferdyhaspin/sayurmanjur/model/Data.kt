package com.ferdyhaspin.sayurmanjur.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ferdyhaspin on 02/04/20.
 * Copyright (c) 2020 SayurMayur Apps All rights reserved.
 */

@Parcelize
data class VegetableData(
    @SerializedName("fruits")
    val fruits: List<Vegetable>,
    @SerializedName("vegetables")
    val vegetables: List<Vegetable>
) : Parcelable

@Parcelize
data class Vegetable(
    @SerializedName("product_english_name")
    var nameEn: String = "",
    @SerializedName("product_indonesia_name")
    var name: String = "",
    @SerializedName("product_photo")
    var photo: String = "",
    @SerializedName("product_description")
    var desc: String = "",
    @SerializedName("product_health_benefit")
    var benefit: String = ""
) : Parcelable