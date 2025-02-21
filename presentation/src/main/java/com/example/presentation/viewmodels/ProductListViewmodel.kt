package com.example.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.core.domain.common.UiState
import androidx.lifecycle.viewModelScope
import com.example.domain.useCase.GetProductListUseCase
import com.example.presentation.ui.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productListUseCase: GetProductListUseCase) : ViewModel() {

    private val _productList = mutableStateOf(ProductListState())
    val productList: State<ProductListState> get() = _productList

    init { fetchProductList() }

    fun fetchProductList() {
        productListUseCase.invoke().onEach {
            when (it) {
                is UiState.Loading -> {
                    _productList.value = ProductListState(isLoading = true)
                }

                is UiState.Success -> {
                    _productList.value = ProductListState(data = it.data)
                }

                is UiState.Error -> {
                    _productList.value = ProductListState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}