package com.example.toyweverse.data.repo

import com.example.toyweverse.api.response.ShopInfoResponse
import com.example.toyweverse.util.Result


interface WeverseRepository {

    suspend fun getShopInfo() : Result<ShopInfoResponse>
}