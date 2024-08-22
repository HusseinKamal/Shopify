package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("barcode")
    var barcode: String,
    @SerialName("createdAt")
    var createdAt: String,
    @SerialName("qrCode")
    var qrCode: String,
    @SerialName("updatedAt")
    var updatedAt: String
)