package com.example.data.network

import com.example.data.model.ProductListDTO
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getAllProductListAPI() : List<ProductListDTO>
}