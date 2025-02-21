package com.example.presentation.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.presentation.ui.screens.ProductDetailsScreen

@Composable
fun ProductDetailsRoute(productTitle: String) {
    val context = LocalContext.current
    ProductDetailsScreen(context, productTitle)
}