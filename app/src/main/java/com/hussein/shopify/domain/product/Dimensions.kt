package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dimensions(
    @SerialName("depth")
    var depth: Double,
    @SerialName("height")
    var height: Double,
    @SerialName("width")
    var width: Double
)