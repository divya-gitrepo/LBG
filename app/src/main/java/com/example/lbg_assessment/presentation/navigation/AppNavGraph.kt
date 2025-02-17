package com.example.lbg_assessment.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.lbg_assessment.presentation.routes.ProductDetailsRoute
import com.example.lbg_assessment.presentation.routes.ProductListRoute
import com.example.lbg_assessment.utils.Constant.EMPTY_STRING
import com.example.lbg_assessment.utils.Constant.TITLE_STRING

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
