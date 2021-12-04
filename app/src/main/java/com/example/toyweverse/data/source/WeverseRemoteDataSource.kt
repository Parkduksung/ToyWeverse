package com.example.toyweverse.data.source


import com.example.toyweverse.api.response.ShopInfoResponse
import com.example.toyweverse.util.Result


interface WeverseRemoteDataSource {

    suspend fun getShopInfo() : Result<ShopInfoResponse>
}