package com.hussein.shopify

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hussein.shopify.domain.product.ProductX
import com.hussein.shopify.presentation.ui.home.ProductItemCard
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.compose.ui.test.onNodeWithText
import androidx.test.core.app.takeScreenshot

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun testLazyColumnItems() {
      /*  composeRule.setContent {
            MainActivity()
        }*/

        val products = listOf(
            ProductX(
                id = 1,
                title = "Product 1",
                description = "This is a product description1",
                price = 19.99,
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png"
            ),
           /* ProductX(
                id = 2,
                title = "Product 2",
                description = "This is a product description2",
                price = 20.25,
                thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png"
            )*/
        )
        composeRule.setContent {
            ProductItemCard(product = products[0])
        }

        products.forEach { product ->
            composeRule.onNodeWithText(product.title).assertIsDisplayed()
            composeRule.onNodeWithText(product.description).assertIsDisplayed()
        }
    }
}