package com.hussein.shopify.presentation.viewmodel

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.hussein.shopify.MainActivity
import com.hussein.shopify.data.model.Result
import com.hussein.shopify.domain.product.Product
import com.hussein.shopify.domain.product.ProductX
import com.hussein.shopify.domain.repository.ProductRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.mockkObject
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

import org.junit.After
import org.junit.Before
import org.junit.Test
@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

   /* @Before
    fun setup() {
       *//* Dispatchers.setMain(testDispatcher)
        userRepository = mock {
            on { viewModel.getProductData() } doReturn flowOf(Result.Success(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")))
        }
        viewModel = MainViewModel(userRepository)*//*

        val productRepository = mockk<ProductRepository>()
        val mockProduct = ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")
         val product = Product(1, arrayListOf(mockProduct))
        every { productRepository.getProductData() } returns flowOf(Result.Success(product))

        // Initialize ViewModel with mocked dependencies
        viewModel = MainViewModel(productRepository)
    }*/

   /* private val testDispatcher = StandardTestDispatcher()
    private lateinit var userRepository: ProductRepository
    private lateinit var viewModel: MainViewModel*/


    @MockK
    private lateinit var userRepository: ProductRepository

    private lateinit var viewModel: MainViewModel

    private lateinit var testDispatcher: TestDispatcher

    @Before
    fun setup() {
        testDispatcher = StandardTestDispatcher()
        Dispatchers.setMain(testDispatcher)
        MockKAnnotations.init(this)
        userRepository = mockk()
        coEvery { userRepository.getProductData() } returns flowOf(Result.Success(Product(1, arrayListOf(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")), 1)))
        viewModel = MainViewModel(userRepository)
    }



    /*  @Before
      fun setup() {
          Dispatchers.setMain(testDispatcher)
          userRepository = mockk()
          coEvery { userRepository.getProductData() } returns flowOf(Result.Success(Product(1, arrayListOf(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")), 1)))
          viewModel = MainViewModel(userRepository)
      }*/

    /*@Test
    fun `should load products successfully`() {
        // Arrange
        val products = listOf(
            ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail"),
            ProductX(id=2, title = "Test Product2", price = 10.0, description = "Test Description2", thumbnail = "Test Thumbnail2")
        )
        `when`(productRepository.getProductData()).thenReturn(products)

        // Act
        productViewModel.getProductData()

        // Assert
        assertThat((productViewModel.productData.value as Result.Success<Product>)).isEqualTo(products)
        verify(productRepository).()
    }
*/
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

  /*  @Test
    fun `getProductData updates productData state`() *//*= runTest *//*{
      *//*  composeTestRule.setContent {
            MainScreen(mainViewModel = viewModel)
        }

        // Verify that the UI displays the correct product details
        composeTestRule.onNodeWithText("Test Product").assertIsDisplayed()
        composeTestRule.onNodeWithText("Test Description").assertIsDisplayed()
        composeTestRule.onNodeWithText("10.0").assertIsDisplayed()

        // Verify that getProduct() was called on the repository
        verify { viewModel.getProductData() }*//*
        val mockDataSource = mockk<ProductRepository>(relaxed = true)
        mockkObject(ProductRepositoryImpl)
        every { ProductRepositoryImpl.getProductData() } returns "Mock data"

        val repository = ProductRepository(mockDataSource)
        val viewModel = MainViewModel(repository)

        viewModel.getProductData()

        val result = viewModel.productData.value
        assertEquals("Mock data", result)
    }*/

   /* @Test
    fun `getProductData updates productData state`() = runTest {
        viewModel.productData.test {
            assertThat(awaitItem()).isEqualTo(Result.Loading)
            viewModel.getProductData()
            assertThat(awaitItem()).isEqualTo(Result.Success(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")))
            cancelAndIgnoreRemainingEvents()
        }
    }*/

/*    @Test
    fun `getProductDataMockk() emits Loading then Success`() = runBlockingTest {
        // Arrange
        val expectedProduct = Product(1, arrayListOf(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")), 1)
        coEvery { userRepository.getProductData() } returns flowOf(
            Result.Loading,
            Result.Success(expectedProduct)
        )

        // Act
        viewModel.getProductData()

        // Assert
        verify { userRepository.getProductData() }
        assert(viewModel.productData.value is Result.Loading)
        advanceUntilIdle()
        assert(viewModel.productData.value == Result.Success(expectedProduct))
    }
    @Test
    fun `getProductData() emits Error immediately`() = runBlockingTest {
        // Arrange
        val expectedError = Exception("Error fetching data")
        coEvery { userRepository.getProductData() } returns flowOf(Result.Error(expectedError))

        // Act
        viewModel.getProductData()

        // Assert
        verify { userRepository.getProductData() }
        assert(viewModel.productData.value == Result.Error(expectedError))
    }*/
    @Test
    fun `getProductData updates productData state`() = runTest {
        viewModel.productData.test {
            assertThat(awaitItem()).isEqualTo(Result.Loading)
            viewModel.getProductData()  // This line calls the function to trigger the interaction

            val expectedProduct = Product(1, arrayListOf(ProductX(id=1, title = "Test Product", price = 10.0, description = "Test Description", thumbnail = "Test Thumbnail")), 1)

            assertThat(awaitItem()).isEqualTo(Result.Success(expectedProduct))
            cancelAndIgnoreRemainingEvents()
        }
        coVerify { userRepository.getProductData() } // Verify after the interaction
    }
}