package com.example.toyweverse.api

import com.example.toyweverse.api.response.SaleCategoryResponse
import com.example.toyweverse.api.response.ShopInfoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path

interface WeverseApi {

    @GET(SHOP_INFO)
    suspend fun getShopInfo(): ShopInfoResponse

    @GET(SALE_CATEGORY)
    suspend fun getSaleCategoryResponse(
        @Path("ShopId") shopId : Int
    ) :SaleCategoryResponse

    companion object {
        private const val BASE_WEVERSE_URL = "https://us-central1-weverse-d7a79.cloudfunctions.net/"
        private const val SHOP_INFO = "api/v1/shopinfo"
        private const val SALE_CATEGORY = "api/v1/shop/{ShopId}"
        fun create(): WeverseApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_WEVERSE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeverseApi::class.java)
        }
    }

}