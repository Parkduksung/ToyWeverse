package com.example.toyweverse.data.source

import com.example.toyweverse.api.WeverseApi
import com.example.toyweverse.api.response.SaleCategoryResponse
import com.example.toyweverse.api.response.ShopInfoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.toyweverse.util.Result


class WeverseRemoteDataSourceImpl @Inject constructor(private val weverseApi: WeverseApi) :
    WeverseRemoteDataSource {

    override suspend fun getShopInfo(): Result<ShopInfoResponse> = withContext(Dispatchers.IO) {
        return@withContext try {
            Result.Success(weverseApi.getShopInfo())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getSaleCategories(id: Int): Result<SaleCategoryResponse> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                Result.Success(weverseApi.getSaleCategoryResponse(shopId = id))
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
}