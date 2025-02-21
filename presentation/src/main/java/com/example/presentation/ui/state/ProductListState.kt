package com.example.presentation.ui.state

import com.example.domain.model.ProductItem
import com.example.domain.utils.Constant.EMPTY_STRING

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductItem>? = null,
    var error: String = EMPTY_STRING
)