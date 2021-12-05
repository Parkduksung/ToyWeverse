package com.example.toyweverse.data.repo


import com.example.toyweverse.api.response.SaleCategoryResponse
import com.example.toyweverse.api.response.ShopInfoResponse
import com.example.toyweverse.data.source.WeverseRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.toyweverse.util.Result

class WeverseRepositoryImpl @Inject constructor(private val weverseRemoteDataSource: WeverseRemoteDataSource) :
    WeverseRepository {

    override suspend fun getShopInfo(): Result<ShopInfoResponse> = withContext(Dispatchers.IO) {
        return@withContext weverseRemoteDataSource.getShopInfo()
    }

    override suspend fun getSaleCategories(id: Int): Result<SaleCategoryResponse> =
        withContext(Dispatchers.IO) {
            return@withContext weverseRemoteDataSource.getSaleCategories(id = id)
        }
}