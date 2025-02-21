package com.example.data.repository

import com.example.data.mapper.toProductList
import com.example.data.network.ApiService
import com.example.domain.model.ProductItem
import com.example.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductRepository {
    override suspend fun getProductList(): List<ProductItem> {
        return apiService.getAllProductListAPI().map { it.toProductList() }
    }
}