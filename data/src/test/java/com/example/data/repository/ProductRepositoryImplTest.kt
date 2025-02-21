package com.example.data.repository

import com.example.data.model.ProductListDTO
import com.example.data.network.ApiService
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import com.example.data.mapper.toProductList

@ExperimentalCoroutinesApi
class ProductRepositoryImplTest {
    private lateinit var productRepositoryImpl: ProductRepositoryImpl
    @MockK
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        apiService = mock()
        MockitoAnnotations.openMocks(this)
        productRepositoryImpl = ProductRepositoryImpl(apiService)
    }

    @Test
    fun `test getProductList returns mapped list`() = runTest {
        val mockApiResponse = listOf(
            ProductListDTO(
                id = 1,
                title = "Product 1",
                description = "Product Desc",
                image = "",
                category = "",
                price = ""
            ),
            ProductListDTO(
                id = 2,
                title = "Product 2",
                description = "Product Desc",
                image = "",
                category = "",
                price = ""
            ),
        )
        whenever(apiService.getAllProductListAPI()).thenReturn(mockApiResponse)
        val expectedProductList = mockApiResponse.map { it.toProductList() }
        val result = productRepositoryImpl.getProductList()
        assertEquals(expectedProductList, result)
    }

    @Test
    fun `test getProductList returns empty list when api response is empty`() = runTest {
        whenever(apiService.getAllProductListAPI()).thenReturn(emptyList())
        val result = productRepositoryImpl.getProductList()
        TestCase.assertTrue(result.isEmpty())
    }

    @Test(expected = Exception::class)
    fun `test getProductList throws exception when api call fails`() = runTest {
        whenever(apiService.getAllProductListAPI()).thenThrow(Exception("Network error"))
        productRepositoryImpl.getProductList()
    }
}