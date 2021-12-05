package com.example.toyweverse.data.source


import com.example.toyweverse.api.response.SaleCategoryResponse
import com.example.toyweverse.api.response.ShopInfoResponse
import com.example.toyweverse.util.Result


interface WeverseRemoteDataSource {

    suspend fun getShopInfo() : Result<ShopInfoResponse>

    suspend fun getSaleCategories(id : Int) : Result<SaleCategoryResponse>
}