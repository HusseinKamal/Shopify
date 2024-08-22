package com.hussein.shopify.domain.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Review(
    @SerialName("comment")
    var comment: String,
    @SerialName("date")
    var date: String,
    @SerialName("rating")
    var rating: Int,
    @SerialName("reviewerEmail")
    var reviewerEmail: String,
    @SerialName("reviewerName")
    var reviewerName: String
)