package com.example.lbg_assessment.data.repository

import com.example.lbg_assessment.core.common.toProductList
import com.example.lbg_assessment.data.network.ApiService
import com.example.lbg_assessment.domain.model.ProductItem
import com.example.lbg_assessment.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {

    override suspend fun getProductList(): List<ProductItem> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }
}