package com.hussein.shopify.presentation.ui.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hussein.shopify.data.model.Result
import com.hussein.shopify.domain.product.Product
import com.hussein.shopify.domain.product.ProductX
import com.hussein.shopify.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(modifier: Modifier = Modifier, mainViewModel: MainViewModel) {
    LaunchedEffect(key1 = true) {
        mainViewModel.getUserData()
    }
    val productDataModel = mainViewModel.productData.collectAsState()

    val listState = rememberLazyListState()
    val scrollOffset = remember { mutableStateOf(0f) }

    // Animate the offset for smooth transitions
    val animatedOffset = animateFloatAsState(
        targetValue = scrollOffset.value,
        animationSpec = tween(durationMillis = 500)
    ).value

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        when (val result = productDataModel.value) {
            is Result.Loading -> Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp).align(
                    Alignment.Center)) }
            is Result.Success<Product> -> {
                val productData = result.data
                // Calculate scroll offset as a fraction of total scroll distance
                LaunchedEffect(key1 = listState) {
                    scrollOffset.value = listState.firstVisibleItemIndex.toFloat() / productData.products.size
                }
                LazyColumn(modifier = Modifier.fillMaxSize(),state = listState) {
                    items(productData.products){product: ProductX -> //key for refer to specific one in make animateItemPlacement()
                        ProductItemCard(product = product, animatedOffset = animatedOffset)
                    }
                }
            }
            is Result.Error -> Box(modifier = Modifier.fillMaxSize()) { Text(text = "Error: ${result.exception.message}",modifier = Modifier.padding(16.dp)) }
        }
    }
}