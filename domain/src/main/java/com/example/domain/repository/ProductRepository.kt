package com.example.domain.repository

import com.example.domain.model.ProductItem

interface ProductRepository {
    suspend fun getProductList() : List<ProductItem>
}