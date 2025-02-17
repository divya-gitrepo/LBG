package com.example.lbg_assessment.presentation.ui.state

import com.example.lbg_assessment.domain.model.ProductItem
import com.example.lbg_assessment.utils.Constant.EMPTY_STRING

data class ProductListState(
    val isLoading: Boolean = false,
    val data: List<ProductItem>? = null,
    var error: String = EMPTY_STRING
)