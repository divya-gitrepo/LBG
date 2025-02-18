package com.example.lbg_assessment.presentation.routes

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lbg_assessment.presentation.ui.screens.ProductListScreen
import com.example.lbg_assessment.presentation.viewmodels.ProductListVewModel

@Composable
fun ProductListRoute(onCLick:(String) -> Unit){

    val viewModel : ProductListVewModel = hiltViewModel()

    val result = viewModel.productList.value

    ProductListScreen (result, onClick = onCLick)
}