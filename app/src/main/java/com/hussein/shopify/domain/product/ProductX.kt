package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductX(
    @SerialName("availabilityStatus")
    var availabilityStatus: String?=null,
    @SerialName("brand")
    var brand: String?=null,
    @SerialName("category")
    var category: String?=null,
    @SerialName("description")
    var description: String,
    @SerialName("dimensions")
    var dimensions: Dimensions?=null,
    @SerialName("discountPercentage")
    var discountPercentage: Double?=null,
    @SerialName("id")
    var id: Int,
    @SerialName("images")
    var images: List<String>?=ArrayList(),
    @SerialName("meta")
    var meta: Meta?=null,
    @SerialName("minimumOrderQuantity")
    var minimumOrderQuantity: Int?=null,
    @SerialName("price")
    var price: Double,
    @SerialName("rating")
    var rating: Double?=null,
    @SerialName("returnPolicy")
    var returnPolicy: String?=null,
    @SerialName("reviews")
    var reviews: List<Review>?=ArrayList(),
    @SerialName("shippingInformation")
    var shippingInformation: String?=null,
    @SerialName("sku")
    var sku: String?=null,
    @SerialName("stock")
    var stock: Int?=null,
    @SerialName("tags")
    var tags: List<String>?=ArrayList(),
    @SerialName("thumbnail")
    var thumbnail: String,
    @SerialName("title")
    var title: String,
    @SerialName("warrantyInformation")
    var warrantyInformation: String?=null,
    @SerialName("weight")
    var weight: Int?=null
)