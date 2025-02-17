package com.example.lbg_assessment.data.network

import com.example.lbg_assessment.data.model.ProductListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/products")
    suspend fun getAllProductListAPI() : List<ProductListDTO>

}