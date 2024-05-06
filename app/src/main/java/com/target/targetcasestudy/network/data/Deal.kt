package com.target.targetcasestudy.network.data

import com.google.gson.annotations.SerializedName

data class Deal(
    val id: String? = null,
    val title: String? = null,
    val aisle: String? = null,
    val description: String? = null,
    @SerializedName("regular_price")
    val regularPrice: Price? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    val fulfillment: String? = null,
    val availability: String? = null,
    @SerializedName("sale_price")
    val salePrice: Price? = null
)
