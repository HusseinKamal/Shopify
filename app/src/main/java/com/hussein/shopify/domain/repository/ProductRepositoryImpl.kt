package com.hussein.shopify.domain.repository

import com.hussein.shopify.data.remote.ApiService
import com.hussein.shopify.domain.product.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.hussein.shopify.data.model.Result


class ProductRepositoryImpl(private val apiService: ApiService) : ProductRepository {
    override fun getProductData(): Flow<Result<Product>> = flow {
        emit(Result.Loading)
        try {
            val userData = apiService.getUserData()
            emit(Result.Success(userData))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}
