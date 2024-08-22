package com.hussein.shopify.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hussein.shopify.domain.product.Product
import com.hussein.shopify.domain.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import com.hussein.shopify.data.model.Result
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: ProductRepository) : ViewModel() {
    private val _productData = MutableStateFlow<Result<Product>>(Result.Loading)
    val productData: StateFlow<Result<Product>> = _productData

    fun getUserData() {
        viewModelScope.launch {
            userRepository.getProductData().collect {
                _productData.value = it
            }
        }
    }
}