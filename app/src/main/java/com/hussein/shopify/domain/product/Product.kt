package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    @SerialName("limit")
    var limit: Int,
    @SerialName("products")
    var products: List<ProductX>,
    @SerialName("skip")
    var skip: Int,
    @SerialName("total")
    var total: Int
)