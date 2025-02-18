package com.example.lbg_assessment.presentation.viewmodels

import com.example.lbg_assessment.core.common.UiState
import com.example.lbg_assessment.domain.model.ProductItem
import com.example.lbg_assessment.domain.useCase.GetProductListUseCase
import com.example.lbg_assessment.presentation.ui.state.ProductListState
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductListViewModelTest {

    private lateinit var productListViewModel: ProductListVewModel

    @MockK
    private lateinit var getProductListUseCase: GetProductListUseCase
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        Dispatchers.setMain(testDispatcher)
        productListViewModel = ProductListVewModel(getProductListUseCase)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchItems should update items when use case returns success`() = runTest {
        val mockItems = listOf(
            ProductItem(id = 1, title = "Product 1", description = "Description of Product 1", image = "")
        )
        coEvery { getProductListUseCase.invoke() } returns flowOf(UiState.Success(mockItems))

        productListViewModel.fetchProductList()
        advanceUntilIdle()

        val result = productListViewModel.productList.value
        assert(result.data == mockItems)
    }

    @Test
    fun `fetchItems should update items when use case returns failure`() = runTest {
        val mockItems = listOf(
            ProductItem(id = 1, title = "Product 1", description = "Description of Product 1", image = "")
        )
        val mockException = Exception("Test exception")
        coEvery { getProductListUseCase.invoke() } returns  flowOf(UiState.Error(mockItems, mockException.message))

        productListViewModel.fetchProductList()
        advanceUntilIdle()

        val result = productListViewModel.productList.value
        assert(result.error == mockException.message)
    }

    @Test
    fun `items should initially be in loading state`() {
        val initialState = productListViewModel.productList.value
        assert(initialState == ProductListState(initialState.isLoading))
    }

}
