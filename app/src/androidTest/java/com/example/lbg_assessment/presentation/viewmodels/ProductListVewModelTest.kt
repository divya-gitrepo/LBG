/*
package com.example.lbg_assessment.presentation.viewmodels

import com.example.lbg_assessment.core.common.UiState
import com.example.lbg_assessment.data.model.ProductListDTO
import com.example.lbg_assessment.data.repository.ProductRepositoryImpl
import com.example.lbg_assessment.domain.model.ProductItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import com.example.lbg_assessment.data.network.ApiService
import com.example.lbg_assessment.domain.repository.ProductRepository
import com.example.lbg_assessment.domain.useCase.GetProductListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class ProductListVewModelTest {

    private lateinit var mockGetProductsUseCase: GetProductListUseCase
    private lateinit var productViewModel: ProductListVewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {

        mockGetProductsUseCase = mock()
        productViewModel = ProductListVewModel(mockGetProductsUseCase)
    }

    @Test
    fun testLoadProductsReturnsAListOfProducts() = runTest{

        val productList = listOf(
            ProductItem(1, "", "Title1", "Description1"),
            ProductItem(2, "", "Title2", "Description2"),
            )
        whenever(mockGetProductsUseCase.invoke()).thenReturn(flow { UiState.Success(data = productList) })

        // When
        productViewModel.fetchProductList()

        // Then
        assert(productViewModel.productList.value.data == productList)
        verify(mockGetProductsUseCase).invoke()


        */
/*val productList = listOf(
            ProductListDTO("Category1", "Description1", 1, "", "500", "Title1"),
            ProductListDTO("Category2", "Description2", 2, "", "1000", "Title2"),
        )*//*

    }

    @Test
    fun testEmptyProductListOnFailure() = runTest {
        whenever(mockGetProductsUseCase.invoke()).thenThrow(Exception("Network error"))

        // When
        productViewModel.fetchProductList()

        // Then
        assert(productViewModel.productList.value.error.isEmpty())
    }
}
*/
