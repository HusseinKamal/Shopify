package com.hussein.shopify.di

import com.hussein.shopify.data.remote.ApiService
import com.hussein.shopify.domain.repository.ProductRepository
import com.hussein.shopify.domain.repository.ProductRepositoryImpl
import com.hussein.shopify.presentation.viewmodel.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single { ApiService() }
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    factory { MainViewModel(get()) }
}