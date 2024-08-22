package com.hussein.shopify.data.remote

import com.hussein.shopify.domain.Util.BASE_URL
import com.hussein.shopify.domain.Util.PRODUCT_ENDPOINT
import com.hussein.shopify.domain.product.Product
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class ApiService {
    private val client = HttpClient(CIO) {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
    }

    suspend fun getUserData(): Product {
        // Replace with your actual API endpoint
        val response:Product =client.get(BASE_URL + PRODUCT_ENDPOINT).body()
        return response
    }
}