package com.hussein.shopify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hussein.shopify.presentation.ui.theme.ShopifyTheme
import com.hussein.shopify.presentation.viewmodel.MainViewModel
import com.hussein.shopify.data.model.Result
import com.hussein.shopify.domain.product.Product
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.Koin

class MainActivity : ComponentActivity() {
    val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShopifyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding),mainViewModel)
                  /*  Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier=Modifier , mainViewModel: MainViewModel) {
    LaunchedEffect(key1 = true) {
        mainViewModel.getUserData()
    }
    val productDataModel = mainViewModel.productData.collectAsState()

    Column(modifier = modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        when (val result = productDataModel.value) {
            is Result.Loading -> Box(modifier = Modifier.fillMaxSize()) {CircularProgressIndicator(modifier = Modifier.padding(16.dp).align(Alignment.Center)) }
            is Result.Success<Product> -> {
                val productData = result.data
                Text(text = "Name: ${productData.products[0].title}")
                Text(text = "Rate: ${productData.products[0].rating}")
            }
            is Result.Error -> Text(text = "Error: ${result.exception.message}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShopifyTheme {
        //MainScreen()
    }
}