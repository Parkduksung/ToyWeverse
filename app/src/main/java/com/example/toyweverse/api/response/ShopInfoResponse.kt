package com.example.toyweverse.api.response

import com.google.gson.annotations.SerializedName

data class ShopInfoResponse(
    @SerializedName("shopInfos")
    val shopInfos: List<ShopInfo>
)

data class ShopInfo(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("shortName")
    val shortName: String,
    @SerializedName("type")
    val type: String
)