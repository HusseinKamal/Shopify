package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductX(
    @SerialName("availabilityStatus")
    var availabilityStatus: String,
    @SerialName("brand")
    var brand: String?=null,
    @SerialName("category")
    var category: String,
    @SerialName("description")
    var description: String,
    @SerialName("dimensions")
    var dimensions: Dimensions,
    @SerialName("discountPercentage")
    var discountPercentage: Double,
    @SerialName("id")
    var id: Int,
    @SerialName("images")
    var images: List<String>,
    @SerialName("meta")
    var meta: Meta,
    @SerialName("minimumOrderQuantity")
    var minimumOrderQuantity: Int,
    @SerialName("price")
    var price: Double,
    @SerialName("rating")
    var rating: Double,
    @SerialName("returnPolicy")
    var returnPolicy: String,
    @SerialName("reviews")
    var reviews: List<Review>,
    @SerialName("shippingInformation")
    var shippingInformation: String,
    @SerialName("sku")
    var sku: String,
    @SerialName("stock")
    var stock: Int,
    @SerialName("tags")
    var tags: List<String>,
    @SerialName("thumbnail")
    var thumbnail: String,
    @SerialName("title")
    var title: String,
    @SerialName("warrantyInformation")
    var warrantyInformation: String,
    @SerialName("weight")
    var weight: Int
)