package com.example.toyweverse.api.response

import com.google.gson.annotations.SerializedName

data class SaleCategoryResponse(
    @SerializedName("saleCategories")
    val saleCategories: List<SaleCategory>
)

data class SaleCategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("sales")
    val sales: List<Sale>
)

data class Sale(
    @SerializedName("id")
    val id: Int,
    @SerializedName("imageUrl")
    val imageUrl: String,
    @SerializedName("isPreOrder")
    val isPreOrder: Boolean,
    @SerializedName("isSoldOut")
    val isSoldOut: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("originalPrice")
    val originalPrice: Int,
    @SerializedName("salePrice")
    val salePrice: Int
)