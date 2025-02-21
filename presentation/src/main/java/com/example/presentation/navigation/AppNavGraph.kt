package com.example.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.domain.utils.Constant.EMPTY_STRING
import com.example.domain.utils.Constant.TITLE_STRING
import com.example.presentation.routes.ProductDetailsRoute
import com.example.presentation.routes.ProductListRoute

fun NavGraphBuilder.addToDest(onClick:(String) -> Unit){
    composable(route = NavigationLBG.ProductListScreen.route) {
        ProductListRoute(onCLick = onClick)
    }
}

fun NavGraphBuilder.toDetailsScreen(){
    composable(route = NavigationLBG.ProductDetailsScreen.route +"/{$TITLE_STRING}") {
        val argument = it.arguments?.getString(TITLE_STRING)?: EMPTY_STRING
        ProductDetailsRoute(argument)
    }
}
