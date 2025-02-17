package com.example.lbg_assessment.domain.repository

import com.example.lbg_assessment.domain.model.ProductItem

interface ProductRepository {

    suspend fun getProductList() : List<ProductItem>
}