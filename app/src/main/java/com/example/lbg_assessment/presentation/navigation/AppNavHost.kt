package com.example.lbg_assessment.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lbg_assessment.presentation.routes.ProductDetailsRoute
import com.example.lbg_assessment.presentation.ui.screens.ProductDetailsScreen

@Composable
fun AppNavHost() {

    val navController = rememberNavController()
    val onCLick: (String) -> Unit = {
        navController.navigate(it)
    }
    NavHost(navController = navController,
        startDestination = NavigationLBG.ProductListScreen.route){
        addToDest(onCLick)
        toDetailsScreen()
    }



}