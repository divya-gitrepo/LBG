package com.example.presentation.routes

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.ui.screens.ProductListScreen
import com.example.presentation.viewmodels.ProductListViewModel

@Composable
fun ProductListRoute(onCLick:(String) -> Unit){
    val viewModel : ProductListViewModel = hiltViewModel()
    val result = viewModel.productList.value
    ProductListScreen (result, onClick = onCLick)
}