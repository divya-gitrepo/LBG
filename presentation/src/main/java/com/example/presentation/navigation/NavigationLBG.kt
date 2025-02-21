package com.example.presentation.navigation

sealed class NavigationLBG(val route: String) {
    data object ProductListScreen: NavigationLBG(route = "ProductListScreen")
    data object ProductDetailsScreen: NavigationLBG(route = "ProductDetailsScreen")
}