package com.hussein.shopify.domain.repository

import com.hussein.shopify.data.model.Result
import com.hussein.shopify.domain.product.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getProductData(): Flow<Result<Product>>

}