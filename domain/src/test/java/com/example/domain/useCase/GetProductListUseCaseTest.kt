package com.example.domain.useCase

import com.example.core.domain.common.UiState
import com.example.domain.model.ProductItem
import com.example.domain.repository.ProductRepository
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class FakeProductRepository(private val shouldThrowError: Boolean = false) : ProductRepository {
    override suspend fun getProductList(): List<ProductItem> {
        if (shouldThrowError) {
            throw Exception("Error fetching product list")
        }
        return listOf(
            ProductItem(
                id = 1,
                title = "Product 1",
                description = "Description of Product 1",
                image = ""
            )
        )
    }
}

class GetProductListUseCaseTest {
    private lateinit var getProductListUseCase: GetProductListUseCase
    private lateinit var fakeProductRepository: FakeProductRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        fakeProductRepository = FakeProductRepository()
        getProductListUseCase = GetProductListUseCase(fakeProductRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `invoke should return loading state initially`() = runTest {
        val flow = getProductListUseCase()
        val states = flow.toList()
        assertTrue(states[0] is UiState.Loading)
    }

    @Test
    fun `invoke should return success state when repository returns products`() = runTest {
        val flow = getProductListUseCase()
        val states = flow.toList()

        assertTrue(states[0] is UiState.Loading)
        assertTrue(states[1] is UiState.Success)
        if (states[1] is UiState.Success) {
            assertEquals(
                listOf(
                    ProductItem(
                        id = 1,
                        title = "Product 1",
                        description = "Description of Product 1",
                        image = ""
                    )
                ),
                states[1].data
            )
        }
    }

    @Test
    fun `invoke should return error state when repository throws an exception`() = runTest {
        fakeProductRepository = FakeProductRepository(shouldThrowError = true)
        getProductListUseCase = GetProductListUseCase(fakeProductRepository)
        val states = getProductListUseCase().toList()

        assertTrue(states[0] is UiState.Loading)
        assertTrue(states[1] is UiState.Error)
        if (states[1] is UiState.Error) {
            assertEquals("Error fetching product list", states[1].message)
        }
    }
}